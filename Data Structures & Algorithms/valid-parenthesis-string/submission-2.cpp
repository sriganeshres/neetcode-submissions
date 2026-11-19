class Solution {
public:
    bool checkValidString(string s) {
        int n = s.length();
        vector<vector<int>> dp(n+1, vector<int>(n+1, false));
        dp[n][0] = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int open = 0; open <= i; open++) {
                if(s[i] == '(') dp[i][open] |= dp[i+1][open+1];
                else if (s[i] == ')' && open > 0) dp[i][open] |= dp[i+1][open-1];
                else if (s[i] == '*') {
                    dp[i][open] |= (dp[i+1][open+1] | dp[i+1][open]);
                    if (open > 0) dp[i][open] |= dp[i+1][open-1];
                    }
            }
        }

        return dp[0][0] == 1;
    }
};
