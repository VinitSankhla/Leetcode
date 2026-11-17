
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                cost[i][j] = minChangesForSemiPalindrome(s, i, j);
            }
        }

        int INF = 1_000_000_000;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int end = parts * 2; end <= n; end++) {
                for (int prevEnd = (parts - 1) * 2; prevEnd <= end - 2; prevEnd++) {
                    if (dp[prevEnd][parts - 1] != INF) {
                        dp[end][parts] = Math.min(
                            dp[end][parts],
                            dp[prevEnd][parts - 1] + cost[prevEnd][end - 1]
                        );
                    }
                }
            }
        }

        return dp[n][k];
    }

    private int minChangesForSemiPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        int minChanges = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {
            if (len % d != 0) {
                continue;
            }
            int changes = 0;
            for (int mod = 0; mod < d; mod++) {
                int l = left + mod;
                int r = left + mod + ((len / d) - 1) * d;
                while (l < r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        changes++;
                    }
                    l += d;
                    r -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}
