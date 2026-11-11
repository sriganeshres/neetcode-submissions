func numIslands(grid [][]byte) int {
    islands := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == '1' {
				dfs(grid, i, j)
				islands++;
			}
		}
 	}
	return islands
}

func dfs(grid [][]byte, r , c int) {
	if r < 0 || c < 0 || r >= len(grid) || c >= len(grid[0]) || grid[r][c] == '0' {
		return
	}
	grid[r][c] = '0'
	directions := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	for _, dir := range directions {
		dfs(grid, r + dir[0], c + dir[1])
	}
}