class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp = new int[text1.length()][text2.length()];
        for(int[] d: dp) Arrays.fill(d, -1);
        return back(0, 0, text1, text2, dp);
    }

    private int back(int i, int j, String text1, String text2, int [][]dp) {
        if(i >= text1.length() || j >= text2.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + back(i+1, j + 1, text1, text2, dp);
        } else {
            dp[i][j] = Math.max(back(i+1, j, text1,text2, dp), back(i, j + 1, text1, text2, dp));
        }

        return dp[i][j];
    }
}
