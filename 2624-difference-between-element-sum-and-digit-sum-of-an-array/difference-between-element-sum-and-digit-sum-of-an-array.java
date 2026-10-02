class Solution {
    public int differenceOfSum(int[] nums) {
        int ele = 0;
        int digit = 0;

        for (int num : nums) {
            ele += num;

            int temp = num;
            while (temp > 0) {
                digit += temp % 10;
                temp /= 10;
            }
        }

        return Math.abs(ele - digit);
    }
}