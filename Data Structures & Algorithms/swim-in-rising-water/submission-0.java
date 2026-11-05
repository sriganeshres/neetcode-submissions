class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean visit[][] = new boolean[n][n];
        pq.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;
        while(!pq.isEmpty()) {
            int []curr = pq.poll();
            int t = curr[0], x = curr[1], y = curr[2];
            if(x == n - 1 && y == n - 1) return t;
            for(int[] dir: directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    pq.offer(new int[]{Math.max(t, grid[nx][ny]), nx, ny});
                }
            }
        }

        return n * n;
    }
}
