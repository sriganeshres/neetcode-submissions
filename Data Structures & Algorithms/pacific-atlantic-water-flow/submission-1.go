func pacificAtlantic(heights [][]int) [][]int {
	visitedP, visitedA := make(map[[2]int]bool), make(map[[2]int]bool)
	rows, cols := len(heights), len(heights[0])
	for j := 0; j < cols; j++ {
		dfs(heights, visitedP, 0, j, heights[0][j])
		dfs(heights, visitedA, rows - 1, j, heights[rows - 1][j])
	}

	for i := 0; i < rows; i++ {
		dfs(heights, visitedP, i, 0, heights[i][0])
		dfs(heights, visitedA, i, cols - 1, heights[i][cols -1])
	}

	res := make([][]int, 0)
	for i := 0; i < rows; i++ {
		for j := 0; j < cols; j++ {
			pt := [2]int{i, j}
			if visitedP[pt] && visitedA[pt] {
				res = append(res, []int{i, j})
			}
		}
	}

	return res
}

func dfs(grid [][]int, visited map[[2]int]bool, r, c, prevH int) {
	dirs := [][]int{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}
	if r < 0 || c < 0 || r >= len(grid) || c >= len(grid[0]) || grid[r][c] < prevH || visited[[2]int{r, c}] {
			return
		}
	visited[[2]int{r, c}] = true
	for _, dir := range dirs {
		newR, newC := r + dir[0], c + dir[1]
		dfs(grid, visited, newR, newC, grid[r][c])
	}
}