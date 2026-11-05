class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a, b) -> a - b);
        for(int n: nums) {
            pq.offer(n);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}
