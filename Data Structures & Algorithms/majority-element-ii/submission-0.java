class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e: mp.entrySet()) {
            if(e.getValue() > nums.length / 3) {
                ls.add(e.getKey());
            }
        }

        return ls;
    }
}