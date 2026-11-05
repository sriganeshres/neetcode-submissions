class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char t: tasks)
            count[t - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> q = new LinkedList<>();
        for(int c: count) {
            if(c > 0) pq.offer(c);
        }
        int t = 0;
        while(!pq.isEmpty() || !q.isEmpty()) {
            t++;
            if(pq.isEmpty()) {
                t = q.peek()[1];
            } else {
                int cnt = pq.poll() - 1;
                if(cnt != 0) {
                    q.add(new int[]{cnt, t+n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == t) {
                pq.offer(q.poll()[0]);
            }
        }
        return t;
    }
}
