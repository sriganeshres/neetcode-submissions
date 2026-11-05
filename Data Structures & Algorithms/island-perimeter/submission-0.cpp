class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int res = 0;
        int n = grid.size(), m = grid[0].size();
        for(int i =0; i < n; i++) {
            for(int j =0; j < m; j++) {
                if(grid[i][j] == 1) {
                    int surr = 0;
                    if(i > 0) surr += grid[i-1][j]; 
                    if(j > 0) surr += grid[i][j-1]; 
                    if(i < n - 1) surr += grid[i+1][j]; 
                    if(j < m - 1) surr += grid[i][j+1];
                    res += (4 - surr); 
                }
            }
        }
        return res;
    }
};