func maxAreaOfIsland(grid [][]int) int {
    maxArea := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				a := dfs(grid, i, j)
				if a > maxArea {
					maxArea = a
				}
			}
		}
 	}
	return maxArea
}

func dfs(grid [][]int, r , c int) int {
	if r < 0 || c < 0 || r >= len(grid) || c >= len(grid[0]) || grid[r][c] == 0 {
		return 0
	}
	grid[r][c] = 0
	ans := 1
	directions := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	for _, dir := range directions {
		ans += dfs(grid, r + dir[0], c + dir[1])
	}
	return ans
}