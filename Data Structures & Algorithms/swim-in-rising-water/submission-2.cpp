class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        int n = grid.size();
        set<pair<int, int>> visit;
        priority_queue<vector<int>, vector<vector<int>>, greater<>> pq;
        vector<vector<int>> directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        pq.push({grid[0][0], 0, 0});
        visit.insert({0, 0});

        while(!pq.empty()) {
            auto node = pq.top();
            pq.pop();
            int t = node[0], r = node[1], c = node[2];
            if(r == n-1 && c == n-1) {
                return t;
            }

            for(auto& dir: directions) {
                int neir = r + dir[0], neic = c + dir[1];
                if (neir < 0 || neic < 0 || neir >= n || neic >= n || visit.count({neir, neic})) {
                    continue;
                }
                pq.push({max(t, grid[neir][neic]), neir, neic});
                visit.insert({neir, neic});
            }
        }

        return n * n;
    }
};
