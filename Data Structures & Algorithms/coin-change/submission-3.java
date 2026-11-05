class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int)1e9);
        for(int k: coins) {
            if(k <= amount) dp[k] = 1;
        }
        for(int i = 1; i <= amount; i++) {
            for(int k: coins) {
                if(i >= k) {
                    dp[i] = Math.min(dp[i-k] + 1, dp[i]);
                }
            }
        }

        return dp[amount] >= 1e9 ? -1 : dp[amount];
    }
}
