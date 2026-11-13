func solve(board [][]byte) {
	rows, cols := len(board), len(board[0])
    for r := 0; r < rows; r++ {
        if board[r][0] == 'O' {
            dfs(board, r, 0)
        }
        if board[r][cols-1] == 'O' {
            dfs(board, r, cols-1)
        }
    }

    for c := 0; c < cols; c++ {
        if board[0][c] == 'O' {
            dfs(board, 0, c)
        }
        if board[rows-1][c] == 'O' {
            dfs(board, rows-1, c)
        }
    }

	for r := 0; r < rows; r++ {
        for c := 0; c < cols; c++ {
            if board[r][c] == 'O' {
                board[r][c] = 'X'
            } else if board[r][c] == 'T' {
                board[r][c] = 'O'
            }
        }
    }
}

func dfs(grid [][]byte, r, c int) {
	dirs := [][]int{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}
	if r < 0 || c < 0 || r >= len(grid) || c >= len(grid[0]) || grid[r][c] != 'O' {
			return
		}
	grid[r][c] = 'T'
	for _, dir := range dirs {
		newR, newC := r + dir[0], c + dir[1]
		dfs(grid, newR, newC)
	}
}