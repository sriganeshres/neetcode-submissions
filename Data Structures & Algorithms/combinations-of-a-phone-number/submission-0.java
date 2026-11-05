class Solution {
    String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        f(0, "", digits, res);
        return res; 
    }

    public void f(int i, String s, String digits, List<String> res) {
        if(s.length() == digits.length()) {
            res.add(s);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c: chars.toCharArray()) {
            f(i + 1, s + c, digits, res);
        }
    }
}
