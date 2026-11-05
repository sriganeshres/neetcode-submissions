class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hp.containsKey(target - nums[i])) {
                int[] ans = new int[2];
                ans[0] = hp.get(target - nums[i]);
                ans[1] =  i;
                return ans;
            }
            hp.put(nums[i], i);
        }
        return new int[0];
    }
}
