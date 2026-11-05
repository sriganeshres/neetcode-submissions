class Solution {
    int totalSum = 0;
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        int n = nums.length;
        for(int i: nums) totalSum += i;
        dp = new int[n][2*totalSum + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*totalSum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return back(0, 0, target, nums);
    }

    int back(int i, int total, int target, int[] nums) {
        if(i == nums.length) {
            return target == total ? 1 : 0;
        }

        if(dp[i][total + totalSum] != -1) return dp[i][total + totalSum];
        dp[i][total + totalSum] = back(i + 1, total + nums[i], target, nums) + back(i + 1, total - nums[i], target, nums);
        return dp[i][totalSum + total];
    }
}
