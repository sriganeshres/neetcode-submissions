class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int []time: times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }

        pq.offer(new int[]{0, k});
        HashSet<Integer> visited = new HashSet<>();
        int t = 0;
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            int weight = curr[0], node = curr[1];
            if(visited.contains(node)) continue; 
            visited.add(node);
            t = weight;
            for(int[] ls: adj.get(node)) {
                if(!visited.contains(ls[0])) {
                    pq.offer(new int[]{ls[1] + weight, ls[0]});
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
