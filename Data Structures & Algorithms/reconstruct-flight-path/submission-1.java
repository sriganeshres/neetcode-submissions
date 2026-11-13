class Solution {
    private Map<String, PriorityQueue<String>> adj = new HashMap<>();
    private LinkedList<String> itinerary = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK");

        return itinerary;
    }

    private void dfs(String src) {
        PriorityQueue<String> destinations = adj.get(src);

        while(destinations != null && !destinations.isEmpty()) {
            String dest = destinations.poll();
            dfs(dest);
        }
        itinerary.addFirst(src);
    }
}
