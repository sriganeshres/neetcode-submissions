class Solution {
    public int countComponents(int n, int[][] edges) {
        Set<Integer> s = new HashSet<>();
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge:edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(s.contains(i)) continue;
            q.add(i);
            while(!q.isEmpty()) {
                int node = q.poll();
                s.add(node);
                for(int a: adj.get(node)) {
                    if(!s.contains(a)) {
                        q.add(a);
                    }
                }
            }
            count++;
        }

        return count;
    }
}
