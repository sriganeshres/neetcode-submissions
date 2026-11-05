class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int subcount = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j}); 
                    grid[i][j] = 0;
                    while(!q.isEmpty()) {
                        subcount++;
                        int[] p = q.poll();
                        int ii = p[0], jj = p[1];
                        if(ii < n - 1 && grid[ii + 1][jj] == 1) {
                            q.add(new int[]{ii + 1, jj});
                            grid[ii + 1][jj] = 0;
                        }
                        if(ii > 0 && grid[ii - 1][jj] == 1) {
                            q.add(new int[]{ii - 1, jj});
                            grid[ii - 1][jj] = 0;
                        } 
                        if(jj < m - 1 && grid[ii][jj + 1] == 1) {
                            q.add(new int[]{ii, jj + 1});
                            grid[ii][jj + 1] = 0;
                        }
                        if(jj > 0 && grid[ii][jj - 1] == 1)  {
                            q.add(new int[]{ii, jj - 1});
                            grid[ii][jj - 1] = 0;
                        }
                    }
                    count = Math.max(subcount, count);
                }
            }
        }

        return count;
    }
}
