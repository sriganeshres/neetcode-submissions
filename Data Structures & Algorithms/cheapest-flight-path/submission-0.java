class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = (int)1e9;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int source = curr[0], stops = curr[1], distance = curr[2];
            dist[source] = Math.min(distance, dist[source]);
            for(int[] l: adj.get(source)) {
                if(stops <= k) {
                    q.offer(new int[]{l[0], stops + 1, l[1] + distance});
                }
            }
        }
        return dist[dst] == 1e9 ? -1: dist[dst];
    }
}
