class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        stack<int> st;
        vector<int> left(n, -1), right(n, n);

        for(int i = 0; i < n; i++) {
            while(!st.empty() && heights[st.top()] > heights[i]) {
                right[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }

        for(int i = n -1; i >= 0; i--) {
            while(!st.empty() && heights[st.top()] > heights[i]) {
                left[st.top()] = i;
                st.pop();
            }
            st.push(i);
        }

        int maxH = 0;
        for(int i = 0; i < n; i++) {
            maxH = max(maxH, heights[i] * (right[i] - left[i] - 1));
        }

        return maxH;
    }
};
