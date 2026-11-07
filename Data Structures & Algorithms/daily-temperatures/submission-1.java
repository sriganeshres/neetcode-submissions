class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && st.peek()[0] < temperatures[i]) {
                int[] x = st.pop();
                result[x[1]] = i - x[1];
            }
            st.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
