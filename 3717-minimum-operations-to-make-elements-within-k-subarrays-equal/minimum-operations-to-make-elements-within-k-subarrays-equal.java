class Solution {
    int m;
    long[] cntBit, sumBit;

    void update(int i, long c, long v) {
        for (; i <= m; i += i & -i) {
            cntBit[i] += c;
            sumBit[i] += v;
        }
    }

    // returns {count, sum} of values with index <= i
    long[] query(int i) {
        long c = 0, s = 0;
        for (; i > 0; i -= i & -i) {
            c += cntBit[i];
            s += sumBit[i];
        }
        return new long[]{c, s};
    }

    // index (1-based) of the k-th smallest element
    int kth(int k) {
        int pos = 0;
        int pw = Integer.highestOneBit(m);
        for (; pw > 0; pw >>= 1) {
            if (pos + pw <= m && cntBit[pos + pw] < k) {
                pos += pw;
                k -= cntBit[pos];
            }
        }
        return pos + 1;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // coordinate compression
        int[] sorted = Arrays.stream(nums).distinct().sorted().toArray();
        m = sorted.length;
        cntBit = new long[m + 1];
        sumBit = new long[m + 1];
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = Arrays.binarySearch(sorted, nums[i]) + 1;
        }

        // cost[i] = cost to make window [i, i + x - 1] equal
        int w = n - x + 1;
        long[] cost = new long[w];
        long windowSum = 0;

        for (int i = 0; i < n; i++) {
            update(idx[i], 1, nums[i]);
            windowSum += nums[i];

            if (i >= x) {
                update(idx[i - x], -1, -nums[i - x]);
                windowSum -= nums[i - x];
            }

            if (i >= x - 1) {
                int medIdx = kth((x + 1) / 2);
                long med = sorted[medIdx - 1];
                long[] pre = query(medIdx);
                long cntLE = pre[0], sumLE = pre[1];

                long c = med * cntLE - sumLE
                       + (windowSum - sumLE) - med * (x - cntLE);
                cost[i - x + 1] = c;
            }
        }

        // dp over number of chosen windows
        final long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int j = 1; j <= k; j++) Arrays.fill(dp[j], INF);
        // dp[0][*] = 0

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] < INF) {
                    dp[j][i] = Math.min(dp[j][i], dp[j - 1][i - x] + cost[i - x]);
                }
            }
        }

        return dp[k][n];
    }
}