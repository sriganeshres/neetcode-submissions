class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{0, heights[0]});
        int maxArea = 0;
        for(int i = 1; i < heights.length; i++) {
            int start = i;
            while(!st.isEmpty() && st.peek()[1] > heights[i]) {
                int[] x = st.pop();
                maxArea = Math.max((i - x[0]) * x[1], maxArea);
                start = x[0];
            }
            st.push(new int[]{start, heights[i]});
        }

        for(int[] x: st) {
            maxArea = Math.max((heights.length - x[0]) * x[1], maxArea);
        }

        return maxArea;
    }
}
