class Solution {
    public int[] sortedSquares(int[] nums) {
        // for(int i=0;i<nums.length;i++){
        //     nums[i]=nums[i]*nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;  // but this method is trivial 
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        for(int k = res.length-1; k>=0;k--){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                res[k]=nums[i]*nums[i];
                i++;
            }
            else{
                res[k]=nums[j]*nums[j];
                j--;
            }
            
        }
        return res;
    }
}