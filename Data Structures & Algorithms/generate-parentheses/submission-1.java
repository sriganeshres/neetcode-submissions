class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> st = new Stack<>(); 
        f(0, 0, n, st, res);
        return res;
    }

    public void f(int open, int close, int n, Stack<Character> st, List<String> res) {
        if(open == close && open == n) {
            StringBuilder sb = new StringBuilder();
            for(char c: st) sb.append(c);
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            st.push('(');
            f(open + 1, close, n, st, res);
            st.pop();
        }

        if(close < open) {
            st.push(')');
            f(open, close+1, n, st, res);
            st.pop();
        }

    }
}
