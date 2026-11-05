class Solution {
public:
    vector<vector<int>> dp;
    int maxCoins(vector<int>& coins) {
        int n = coins.size();
        vector<int> newCoins(n+2, 1);
        dp = vector(n+2, vector<int>(n+2, -1));
        for(int i = 0; i < n; i++) newCoins[i+1] = coins[i];
        return back(1, n, newCoins);
    }

    int back(int l, int r, vector<int>& coins) {
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        dp[l][r] = 0;
        for(int i = l; i <= r; i++) {
            int val = coins[l - 1] * coins[i] * coins[r + 1];
            val += back(l, i-1, coins) + back(i+1, r, coins);
            dp[l][r] = max(dp[l][r], val);
        }
        return dp[l][r];
    }
};
