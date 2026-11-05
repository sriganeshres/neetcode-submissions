class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: stones)
            pq.offer(-n);
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(b > a) pq.offer(a - b);
        }

        pq.offer(0);
        return Math.abs(pq.peek());
    }
}
