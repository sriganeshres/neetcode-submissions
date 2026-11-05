class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }

        if(q.size() == 0) return;
        int [][]directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int i = point[0], j = point[1];
            for(int []dir: directions) {
                int ii = i + dir[0], jj = j + dir[1];
                if(ii >= n || ii < 0 || jj >= m || jj < 0 || grid[ii][jj] != 
                Integer.MAX_VALUE) {
                    continue;
                }
                grid[ii][jj] = grid[i][j] + 1;
                q.add(new int[]{ii, jj});
            }
        }
    }
}
