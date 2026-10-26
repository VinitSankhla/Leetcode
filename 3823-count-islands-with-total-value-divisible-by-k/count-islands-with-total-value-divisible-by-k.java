class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]>0){
                    long sum = DFS(i,j,grid);
                    if(sum%k==0) count ++;
                }
            }
        }
        return count;
    }
    public long DFS (int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        long sum=grid[i][j];
        grid[i][j]=0;
        int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
        for(int[] dir : directions){
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if(i_>=0 && j_>=0 && i_<m && j_<n && grid[i_][j_]>0){
                sum += DFS(i_,j_,grid);
            }
        }
        
        return sum;
    }
}