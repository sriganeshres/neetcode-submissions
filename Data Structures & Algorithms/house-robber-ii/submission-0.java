class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(f(nums, 0, nums.length - 1), f(nums, 1, nums.length));
    }

    public int f(int[] nums, int k, int j) {
        // return Math.max(f(nums, 0), f(nums, 1));
        int dp[] = new int[j + 1];
        dp[j - 1] = nums[j - 1];
        for(int i = j - 2; i >= k; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]); 
        }
        return Math.max(dp[k], dp[k + 1]);
    }
}
