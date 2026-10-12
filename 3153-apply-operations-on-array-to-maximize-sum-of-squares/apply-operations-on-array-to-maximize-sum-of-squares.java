class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int mod = 1000000007;
        int[] count= new int [32];
        for (int numA : nums){
            for(int i =0;i<32;i++){
                if((numA & (1 << i)) !=0){
                    count[i]++; // found a 1 in this bit position so adding it to the count 
                }
            }
        }
        long result = 0;
        while(k>0){
            int curr = 0;
            for(int i =0;i<32;i++){
                if(count[i]>0){
                    count[i]--;
                    curr = (curr | (1<<i));
                }
            }
            result = (result + (long )curr*curr)%mod;
            k--;
        }
        return (int) result;
    }
}