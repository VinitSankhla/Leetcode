class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum =0;
        int n = nums.size();
        HashSet<Integer> unique = new HashSet<Integer>();
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                unique.add(nums.get(j));
                int a = unique.size();
                sum += a*a;
            }
            unique.clear();
        }
        return sum;
    }
}