class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int ab = Math.abs(nums[i]);
            if(nums[ab - 1] < 0) return ab;
            else nums[ab - 1] *= -1; 
        }
        return 0;
    }
}
