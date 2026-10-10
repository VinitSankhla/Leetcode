class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] countDiff = new int[100001];
        for(int i = 0;i<n;i++){
            int d = Math.abs(nums1[i] - nums2[i]);
            countDiff[d]++;
        }
        int k = k1+k2;

        for(int currDiff = 100000; currDiff>0 && k > 0 ; currDiff--){
            int countOps = Math.min(countDiff[currDiff],k);

            countDiff[currDiff] -= countOps;
            countDiff[currDiff-1] += countOps;
            k -= countOps;
        }
        long result = 0;
        for(long d = 1;d<=100000;d++){
            result += (long) countDiff[(int) d] * d * d;
        }
        return result;
    }
}