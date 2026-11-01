class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;
        for(int i : nums){
            min=Math.min(min,i);
            sum+=i;
        }
        return (int) (sum- (long) nums.length * min);
    }
}