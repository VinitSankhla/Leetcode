class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long small = 0;
        for(int i =0;i<n/2;i++){
            small += nums[i];
        }
        long large = 0;
        for(int i =n/2;i<n;i++){
            large += nums[i];
        }
        return large - small;
    }
}