class Solution {
public:
    vector<vector<int>> directions = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        vector<vector<int>> dp(matrix.size(), vector<int>(matrix[0].size(), -1));
        int maX = 0;
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix[0].size(); j++) {
                maX = max(maX, back(i, j, matrix, dp, INT_MIN));
            }
        }
        return maX;
    }

    int back(int i, int j, vector<vector<int>>& matrix, vector<vector<int>>& dp, int prevValue) {
        if(i >= matrix.size() || j >= matrix[0].size() || i < 0 || j < 0 || prevValue >= matrix[i][j]) 
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int temp = 1;
        for(vector<int> dir: directions) {
            temp = max(temp, 1 + back(i+dir[0], j+dir[1], matrix, dp, matrix[i][j]));
        }
        dp[i][j] = temp;
        return dp[i][j];
    }
};
