class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for(int n: nums) hp.put(n, hp.getOrDefault(n, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> m: hp.entrySet()) {
            pq.offer(m);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll().getKey();
        }

        return res;

    }
}
