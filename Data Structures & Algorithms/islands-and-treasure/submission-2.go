func islandsAndTreasure(grid [][]int) {
	m, n := len(grid), len(grid[0])
	q := [][2]int{}
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 0 {
				q = append(q, [2]int{i, j})
			} 
		}
	}

	if len(q) == 0 {
		return
	}

	dirs := [][]int{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}

	for len(q) > 0 {
		pt := q[0]
		q = q[1:]

		for _, dir := range dirs {
			r, c := pt[0]+dir[0], pt[1]+dir[1]
			if r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 2147483647 {
				continue
			}
			q = append(q, [2]int{r, c})
			grid[r][c] = grid[pt[0]][pt[1]] + 1
		}
	}
}
