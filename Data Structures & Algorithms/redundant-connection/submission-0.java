class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegree = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            if(indegree[i] == 1) q.offer(i);
        while(!q.isEmpty()) {
            int node = q.poll();
            indegree[node]--;
            for(int a: adj.get(node)) {
                indegree[a]--;
                if(indegree[a] == 1) q.offer(a);
            }
        }

        for(int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (indegree[u] == 2 && indegree[v] > 0)
                return new int[]{u, v};
        }

        return new int[0];
    }
}
