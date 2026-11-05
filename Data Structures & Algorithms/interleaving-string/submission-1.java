class Solution {
    String A, B, C;
    Boolean [][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        dp = new Boolean[s1.length() + 1][s2.length() + 1];
        A = s1;
        B = s2; 
        C = s3; 
        return back(0, 0, 0);
    }

    public boolean back(int i, int j, int k) {
        if(k == C.length()) {
            return i == A.length() && j == B.length();
        }

        if(dp[i][j] != null) return dp[i][j];
        boolean fin = false;
        if(i < A.length() && A.charAt(i) == C.charAt(k)) {
            fin = back(i + 1, j, k + 1);
        } 
        if(!fin && j < B.length() && B.charAt(j) == C.charAt(k)) {
            fin = back(i, j + 1, k + 1);
        }
        dp[i][j] = fin;
        return dp[i][j];
    }
}
