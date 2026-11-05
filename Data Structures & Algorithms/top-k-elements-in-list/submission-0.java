class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) == true) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int answer[] = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = heap.poll().getKey();
        }

        return answer;
    }
}
