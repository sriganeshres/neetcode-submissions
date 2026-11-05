class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int diff = target - n;
            if(mp.containsKey(diff)) {
                return new int[] {mp.get(diff), i};
            }

            mp.put(n, i);
        }

        return new int[]{};
    }
}
