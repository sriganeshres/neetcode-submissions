class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket: tickets) {
            adj.computeIfAbsent(ticket.get(0),
            k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        List<String> res = new LinkedList<>();
        dfs(adj, "JFK", res);

        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, String start, List<String> res) {
        PriorityQueue<String> pq = adj.get(start);
        while(pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(adj, next, res);
        }
        res.add(start);
    }
}
