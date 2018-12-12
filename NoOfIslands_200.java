class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int noi = 0;
        if(grid == null || grid.length == 0)
            return noi;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    noi++;
                }
            }
        }
        return noi;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(grid, x, y);            
        }
    }
}