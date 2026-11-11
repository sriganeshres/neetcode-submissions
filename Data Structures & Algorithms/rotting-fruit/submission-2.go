func orangesRotting(grid [][]int) int {
    m, n := len(grid), len(grid[0])
	q := [][2]int{}
	fresh, time := 0, 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == 2 {
				q = append(q, [2]int{i, j})
			}
			if grid[i][j] == 1 {
				fresh++
			} 
		}
	}

	if fresh == 0 {
		return 0
	}

	dirs := [][]int{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}
	for fresh > 0 && len(q) > 0 {
		leng := len(q)

		for i := 0; i < leng; i++ {
			current := q[0]
			q = q[1:]

			for _, dir := range dirs {
				newRow := current[0] + dir[0]
                newCol := current[1] + dir[1]

                if newRow >= 0 && newRow < m &&
                   newCol >= 0 && newCol < n &&
                   grid[newRow][newCol] == 1 {
                    grid[newRow][newCol] = 2
                    q = append(q, [2]int{newRow, newCol})
                    fresh--
                }
			}
		}

		time++
	}
	if fresh == 0 {
		return time
	}
	return -1
}
