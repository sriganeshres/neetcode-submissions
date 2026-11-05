class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(fresh > 0 && !q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                int[] curr = q.poll();
                int rotx = curr[0], roty = curr[1];
                for(int []dir: directions) {
                    int r = rotx + dir[0], c = roty + dir[1];
                    if(r < n && r >= 0 && c < m && c >= 0 && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        q.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0? time : -1;
    }
}
