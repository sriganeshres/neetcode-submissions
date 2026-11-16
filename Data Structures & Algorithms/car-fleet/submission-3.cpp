class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<vector<int>> cars;
        for(int i = 0; i < position.size(); i++) {
            cars.push_back({position[i], speed[i]});
        }
        sort(cars.begin(), cars.end(), [](auto &a, auto &b) {
            return a[0] > b[0];
        });

        stack<float> st;
        for(auto c : cars) {
            float t = (target - c[0]) / (c[1] * 1.0f);
            if (!st.empty() && st.top() < t) st.push(t);
            else if (st.empty()) st.push(t);
        }

        return st.size();
    }
};
