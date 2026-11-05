class Solution {
    public int maxCoins(int[] coins) {
        int[][] dp = new int[coins.length + 2][coins.length + 2];
        for(int i[]: dp) Arrays.fill(i, -1);
        int [] newcoins = new int[coins.length + 2];
        newcoins[0] = newcoins[coins.length + 1] = 1;
        for(int i = 0; i < coins.length; i++) {
            newcoins[i+1] = coins[i];
        }
        return back(1, newcoins.length - 2, newcoins, dp);
    }

    int back(int l, int r, int[] newcoins, int[][] dp) {
        if(l > r) return 0;
        if(dp[l][r] != -1) return dp[l][r];
        dp[l][r] = 0;
        for(int i = l; i <= r; i++) {
            int temp = newcoins[l - 1] * newcoins[i] * newcoins[r + 1];
            temp += back(l, i - 1, newcoins, dp) + back(i + 1, r, newcoins, dp);
            dp[l][r] = Math.max(dp[l][r], temp);
        }
        return dp[l][r];
    }
}
