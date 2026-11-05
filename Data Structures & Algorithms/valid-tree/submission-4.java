class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int []edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        s.add(0);
        q.add(new int[]{0, -1});
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int node = p[0], par = p[1];
            for(int i: adj.get(node)) {
                if(i == par) continue;
                if(s.contains(i)) return false;
                s.add(i);
                q.add(new int[]{i, node});
            }
        }

        return s.size() == n;
    }
}
