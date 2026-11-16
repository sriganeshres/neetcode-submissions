class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> result(n, 0);
        stack<vector<int>> st;
        for(int i = 0; i < n; i++) {
            while(!st.empty() && st.top()[1] < temperatures[i]){
                vector<int> val = st.top();
                result[val[0]] = i - val[0];
                st.pop();
            }
            st.push({i, temperatures[i]});
        }
        return result;
    }
};
