class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        f(0, n, board, res);
        return res;
    }

    public void f(int i, int n, char[][] board, List<List<String>> res) {
        if(i == n) {
            List<String> br = new ArrayList<>();
            for (char[] row : board) {
                br.add(new String(row));
            }
            res.add(br);
            return;
        }

        for(int j = 0; j < n; j++) {
            if(isSafe(board, i, j)) {
                board[i][j] = 'Q';
                f(i+1, n, board, res);
                board[i][j] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board, int r, int c) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
