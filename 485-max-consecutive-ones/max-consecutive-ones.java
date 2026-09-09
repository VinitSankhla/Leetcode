class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int a=0;
        int b=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                a+=1;
                if(a>b){
                    b=a;
                }
            }
            else{a=0;}
        }
        return b;
    }
}