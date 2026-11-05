class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));
        for(int[] a: points) {
            pq.offer(a);
            if(pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i] = pq.poll();
            i++;
        }
        return res;
    }

    public int dist(int[] x) {
        return x[0]*x[0] + x[1]*x[1];
    }
}
