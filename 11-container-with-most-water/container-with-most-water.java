class Solution {
    public int maxArea(int[] height) {
        int lp = 0;
        int rp = height.length-1;
        int maxarea = 0;
        while(lp<rp){
            int width = rp-lp;
            int h = Math.min(height[lp],height[rp]);
            int curarea = width*h;
            maxarea = Math.max(curarea,maxarea);
            if(height[lp]<height[rp]){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxarea;        
    }
}