class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) continue;

                for (int d = 0; d < 2; d++) {
                    int ni = i, nj = j, dir = d;
                    if (dir == 0) nj++; else ni++;
                    while (ni < m && nj < n && grid[ni][nj] == 1) {
                        if (dir == 0) { dir = 1; ni++; }
                        else          { dir = 0; nj++; }
                    }

                    if (ni < m && nj < n) {
                        dp[ni][nj] = (dp[ni][nj] + dp[i][j]) % MOD;
                    }
                }
            }
        }
        return (int) dp[m - 1][n - 1];
    }
}