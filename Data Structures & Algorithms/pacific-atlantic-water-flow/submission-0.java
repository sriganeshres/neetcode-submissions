class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols], atlantic = new boolean[rows][cols];
        for(int i = 0; i < cols; i++){
            dfs(0, i, pacific, heights);
            dfs(rows - 1, i, atlantic, heights);
        }

        for(int i = 0; i < rows; i++){
            dfs(i, 0, pacific, heights);
            dfs(i, cols - 1, atlantic, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        visited[r][c] = true;
        for(int[] dir: directions) {
            int row = r + dir[0], col = c + dir[1];
            if(row >= 0 && row < rows && col >= 0 && col < cols && heights[row][col] >= heights[r][c] && !visited[row][col]) {
                dfs(row, col, visited, heights);
            }
        }
    }
}
