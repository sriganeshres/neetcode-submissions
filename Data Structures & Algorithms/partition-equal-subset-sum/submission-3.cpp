class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0);
        if (sum % 2 == 1) return false;
        vector<vector<bool>> dp(nums.size() + 1, vector<bool>(sum/2 + 1, false));
        dp[0][0] = true;
        for(int i = 1; i <= nums.size(); i++) {
            for(int j = 1; j <= sum/2; j++) {
                if (nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[nums.size()][sum/2];
    }
};
