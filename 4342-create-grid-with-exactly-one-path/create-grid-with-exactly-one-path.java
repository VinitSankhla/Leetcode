class Solution {
    public String[] createGrid(int n, int m) {
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = '#';
            }
        }

        for (int j = 0; j < m; j++) {
            grid[0][j] = '.';
        }
        for (int i = 0; i < n; i++) {
            grid[i][m - 1] = '.';
        }

        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = new String(grid[i]);
        }

        return ans;
    }
}