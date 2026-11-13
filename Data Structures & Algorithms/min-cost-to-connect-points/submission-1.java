class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        int res = 0;
        for(int i = 1; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }

        for (int step = 0; step < n; step++) {
            int minIdx = -1, mindis = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minDist[j] < mindis) {
                    minIdx = j;
                    mindis = minDist[j];
                }
            }

            visited[minIdx] = true;
            res += mindis;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    minDist[j] = Math.min(minDist[j], dist(points[minIdx], points[j]));
                }
            }
        }

        return res;
    }

    private int dist (int[] x, int[] y) {
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }
}
