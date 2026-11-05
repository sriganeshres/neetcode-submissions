class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        f(n, 0, 0, stack, res);
        return res;
    }

    private void f(int n, int open, int closed, Stack<Character> stack, List<String> res) {
        if(open == closed && open == n) {
            StringBuilder sb = new StringBuilder();
            for(char c: stack) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            stack.push('(');
            f(n, open + 1, closed, stack, res);
            stack.pop();
        }

        if(closed < open) {
            stack.push(')');
            f(n, open, closed + 1, stack, res);
            stack.pop();
        }
    }
}
