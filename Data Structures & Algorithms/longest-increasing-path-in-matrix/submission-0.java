class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int[] d:dp) Arrays.fill(d, -1);
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, back(i, j, matrix, dp, Integer.MIN_VALUE));
            }
        }

        return max;
    }

    public int back(int i, int j, int[][] matrix, int[][] dp, int prevValue) {
        if(i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || prevValue >= matrix[i][j]) 
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int temp = 1;
        for(int[] dir: directions) {
            temp = Math.max(temp, 1 + back(i+dir[0], j+dir[1], matrix, dp, matrix[i][j]));
        }
        dp[i][j] = temp;
        return dp[i][j];
    }
}
