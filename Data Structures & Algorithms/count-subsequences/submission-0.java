class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        if(s.length() == t.length()) return s.equals(t) ? 1 : 0;
        int dp[][] = new int[s.length()  + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return back(0, 0, s, t, dp);
    }

    private int back(int i, int j, String s, String t, int dp[][]) {
        if(i > s.length() || j > t.length()) return 0;
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = back(i+1, j, s, t, dp);
        if(s.charAt(i) == t.charAt(j)) {
            dp[i][j] += back(i + 1, j + 1, s, t, dp);
        }

        return dp[i][j];
    }
}
