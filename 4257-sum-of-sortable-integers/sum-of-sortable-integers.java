class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            int m = n / k;
            int[] minVal = new int[m];
            int[] maxVal = new int[m];
            boolean possible = true;

            for (int b = 0; b < m; b++) {
                int start = b * k;
                int end = start + k;

                int dropCount = 0;
                for (int i = start; i < end - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        dropCount++;
                    }
                }

                if (dropCount == 0) {
                    minVal[b] = nums[start];
                    maxVal[b] = nums[end - 1];
                } else if (dropCount == 1) {
                    if (k > 1 && nums[end - 1] <= nums[start]) {
                        int bMin = nums[start];
                        int bMax = nums[start];
                        for (int i = start; i < end; i++) {
                            if (nums[i] < bMin) bMin = nums[i];
                            if (nums[i] > bMax) bMax = nums[i];
                        }
                        minVal[b] = bMin;
                        maxVal[b] = bMax;
                    } else {
                        possible = false;
                        break;
                    }
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            for (int b = 0; b < m - 1; b++) {
                if (maxVal[b] > minVal[b + 1]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                totalSum += k;
            }
        }

        return totalSum;
    }
}