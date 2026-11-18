class Solution {
public:
    bool canJump(vector<int>& nums) {
        int n  = nums.size();
        vector<bool> dp(n, 0);
        dp[n-1] = true;
        for(int i = n - 2; i >= 0; i--) {
            for(int j = nums[i]; j >= 1; j--) {
                if(i+j >= n-1) dp[i] = true;
                dp[i] = dp[i] | dp[i+j];
            }
        }

        return dp[0];
    }
};
