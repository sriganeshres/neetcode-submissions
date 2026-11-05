class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        int res = 0;
        while(visited.size() < n) {
            int []curr = pq.poll();
            int dist = curr[0], node = curr[1];
            if(visited.contains(node)) continue;
            res += dist;
            visited.add(node);
            for(int[] p: adj.getOrDefault(node, Collections.emptyList())) {
                int cost = p[0], neigh = p[1];
                if(!visited.contains(neigh)) {
                    pq.offer(new int[]{cost, neigh});
                }
            }
        }
        return res;
    }
}
