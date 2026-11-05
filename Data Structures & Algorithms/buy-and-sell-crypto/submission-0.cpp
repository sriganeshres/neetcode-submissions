class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxP = 0;
        int minBuy = prices[0];
        for(int i: prices) {
            maxP = max(maxP, i - minBuy);
            minBuy = min(minBuy, i);
        }
        return maxP;
    }
};
