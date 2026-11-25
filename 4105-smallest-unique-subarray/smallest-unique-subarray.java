class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (right + left) / 2;
            boolean found = traverse(nums, mid);
            if (found) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean traverse(int[] nums, int w) {
        int n = nums.length;
        long hashBase = 100003L;
        long hash = 0L;
        long powerNum = 1;
        for (int i = 0; i < w - 1; ++i) {
            powerNum *= hashBase;
        }
        for (int i = 0; i < w; ++i) {
            hash = hash * hashBase + (long)nums[i];
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(hash, 1);
        for (int i = w; i < n; ++i) {
            hash -= (long)nums[i - w] * powerNum;
            hash *= hashBase;
            hash += nums[i];
            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }
        for (Map.Entry<Long, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return true;
            }
        }
        return false;
    }
}