class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        vector<vector<int>> adj(n+1);
        for(int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj[u].push_back(v);
            adj[v].push_back(u);
            vector<bool> visited(n+1, false);
            if(dfs(u, -1, adj, visited)) {
                return edges[i];
            }
        }

        return {};
    }

    bool dfs(int u, int parent, vector<vector<int>>& adj, vector<bool>& visited) {
        visited[u] = true;
        for(auto nei: adj[u]) {
            if (nei == parent) continue;
            if(visited[nei]) return true; 
            if(dfs(nei, u, adj, visited)) return true; 
        }

        return false;
    }
};
