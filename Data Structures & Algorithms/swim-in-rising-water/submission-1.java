class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        pq.offer(new int[]{grid[0][0], 0, 0});
        int maxTime = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] pt = pq.poll();
            int e = pt[0], r = pt[1], c = pt[2];
            if(visited[r][c]) continue;
            maxTime = Math.max(maxTime, pt[0]);
            if(r == n - 1 && c == m - 1) {
                break;
            }
            visited[r][c] = true;
            for(int[] dir: dirs) {
                int newR = r + dir[0], newC = c + dir[1];
                if(newR < 0 || newC < 0 || newR >= n || newC >= m || visited[newR][newC]) {
                    continue;
                }
                pq.offer(new int[]{grid[newR][newC], newR, newC});
            }
        }

        return maxTime;
    }
}
