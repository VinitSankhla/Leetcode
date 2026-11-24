class Solution {
    public static int GCD(int a, int b){
        if (b == 0) {
            return Math.abs(a);
        }
        return GCD(b, a % b);
    }
    public static int LCM(int a, int b){
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a / GCD(a, b) * b);
    }
    public int maxLength(int[] nums) {
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            int product = 1, gcd = 0, lcm = 1;
            for(int j = i; j < nums.length; j++){
                product *= nums[j];
                gcd = GCD(gcd, nums[j]);
                lcm = LCM(lcm, nums[j]);
                if(product == gcd * lcm) length = Math.max(length,j-i+1);
            }
        }
        return length;
    }
}