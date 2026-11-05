class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = arr1.length;
        for(int i : arr1){
            for(int j : arr2){
                if(Math.abs(i-j)<=d){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}