class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int rows, cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if(board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, board); 
            }
        }

        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if(board[rows - 1][i] == 'O') {
                dfs(rows - 1, i, board); 
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {
        board[r][c] = 'T';
        for(int[] dir: directions) {
            int row = r + dir[0], col = c + dir[1];
            if(row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == 'O') {
                dfs(row, col, board);
            }
        }
    }
}
