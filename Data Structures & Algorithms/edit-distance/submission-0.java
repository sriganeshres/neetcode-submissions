class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int d[]: dp) Arrays.fill(d, -1);
        return back(0, 0, word1, word2, dp, word1.length(), word2.length());
    }

    int back(int i, int j, String word1, String word2, int[][] dp, int m, int n) {
        if(i == m) return n - j;
        if(j == n) return m - i;

        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = back(i + 1, j + 1, word1, word2, dp, m , n);
        } else {
            int temp = Math.min(back(i, j + 1, word1, word2, dp, m, n), back(i + 1, j, word1, word2, dp, m, n));
            temp = Math.min(temp, back(i + 1, j + 1, word1, word2, dp, m, n));
            dp[i][j] = 1 + temp;
        }
        return dp[i][j];
    }
}
