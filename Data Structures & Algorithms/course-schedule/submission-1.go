func canFinish(numCourses int, prerequisites [][]int) bool {
    preq := make(map[int][]int)
	for i := 0; i < numCourses; i++ {
        preq[i] = []int{}
    }
	for _, val := range prerequisites {
		preq[val[0]] = append(preq[val[0]], val[1])
	}

	visiting := make(map[int]bool)
	for c := 0; c < numCourses; c++ {
        if !dfs(preq, c, visiting) {
            return false
        }
    }
    return true
}

func dfs(preq map[int][]int, r int, visiting map[int]bool) bool {
	if visiting[r] {
		return false
	}

	if len(preq[r]) == 0 {
		return true
	}

	visiting[r] = true
	for _, pre := range preq[r] {
		if !dfs(preq, pre, visiting) {
			return false
		}
	}
	visiting[r] = false
	preq[r] = []int{}
	return true
}