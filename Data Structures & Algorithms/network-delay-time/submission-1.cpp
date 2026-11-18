class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        unordered_map<int, vector<pair<int, int>>> edges;
        for(auto& time: times) {
            edges[time[0]].push_back({time[1], time[2]});
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
        pq.push({0, k});
        int res = 0;
        set<int> visited;
        while(!pq.empty()) {
            auto node = pq.top();
            pq.pop();
            int w1 = node.first, n1 = node.second;
            if(visited.count(n1)) continue;
            visited.insert(n1);
            res = w1;
            if(edges.count(n1)) {
                for(auto& next: edges[n1]) {
                    int n2 = next.first, w2 = next.second;
                    if(!visited.count(n2)) pq.push({w1+w2, n2});
                }
            }
        }

        return visited.size() == n ? res : -1;
    }
};
