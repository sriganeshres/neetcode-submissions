class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m + n != k) return false;
        vector<vector<bool>> dp(m+1, vector<bool>(n+1, false));
        dp[m][n] = true;
        for(int i = m; i>= 0; i--) {
            for(int j = n; j >= 0; j--) {
                if (s1[i] == s3[i+j] && i < m && dp[i+1][j]) 
                dp[i][j] = true;
                if (s2[j] == s3[i+j] && j < n && dp[i][j+1])
                    dp[i][j] = true;
            }
        }

        return dp[0][0];
    }
};
