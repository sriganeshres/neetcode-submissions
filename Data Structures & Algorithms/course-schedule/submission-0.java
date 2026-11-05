class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int []preq: prerequisites){
            indegree[preq[1]]++;
            adj.get(preq[0]).add(preq[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int finish = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            finish++;
            for(int a: adj.get(node)) {
                indegree[a]--;
                if(indegree[a] == 0) q.add(a);
            }
        }

        return finish == numCourses;

    }
}
