class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
            arr[i][2] = getDigitSum(nums[i]);
        }

        java.util.Arrays.sort(arr, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[2] != b[2]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][1] == i) {
                continue;
            }

            int cycleSize = 0;
            int curr = i;
            while (!visited[curr]) {
                visited[curr] = true;
                curr = arr[curr][1];
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}