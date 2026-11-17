class Solution {
public:
    int maxProfit(vector<int>& prices) {
        vector<vector<int>> dp(prices.size() + 1, vector<int>(2, 0));
        for(int i = prices.size() - 1; i >= 0; i--) {
                int buy = dp[i+1][0] - prices[i];
                int cool = dp[i+1][1];
                dp[i][1] = max(buy,cool);
                    int sell = (i + 2 < prices.size()) ? dp[i+2][1] + prices[i] : prices[i];
                    cool = dp[i+1][0];
                    dp[i][0] = max(cool, sell);
        }

        return dp[0][1];
    }
};
