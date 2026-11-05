class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j}); 
                    while(!q.isEmpty()) {
                        int[] p = q.poll();
                        int ii = p[0], jj = p[1];
                        grid[ii][jj] = '0';
                        if(ii < n - 1 && grid[ii + 1][jj] == '1') q.add(new int[]{ii + 1, jj});
                        if(ii > 0 && grid[ii - 1][jj] == '1') q.add(new int[]{ii - 1, jj});
                        if(jj < m - 1 && grid[ii][jj + 1] == '1') q.add(new int[]{ii, jj + 1});
                        if(jj > 0 && grid[ii][jj - 1] == '1') q.add(new int[]{ii, jj - 1});
                    }
                }
            }
        }

        return count;
    }
}
