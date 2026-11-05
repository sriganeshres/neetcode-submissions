class Solution {
    public int rows, cols;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(f(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean f(char[][] board, String word, int i, int j, int k) {
        if(k == word.length()) return true;

        if(i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(k) || board[i][j] == '#') 
            return false;
        
        board[i][j] = '#';
        boolean res = f(board, word, i + 1, j, k + 1) ||
                      f(board, word, i - 1, j, k + 1) ||
                      f(board, word, i, j + 1, k + 1) ||
                      f(board, word, i, j - 1, k + 1);
        board[i][j] = word.charAt(k);
        return res;
    }
}
