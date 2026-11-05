class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int val = board[i][j] - '1';
                    int box = (i / 3) * 3 + (j / 3);
                    if(rows[i][val] == true || cols[j][val] == true || boxes[box][val] == true) {
                        return false;
                    }
                    rows[i][val] = true;
                    cols[j][val] = true;
                    boxes[box][val] = true;
                }
            }
        }

        return true;
    }
}
