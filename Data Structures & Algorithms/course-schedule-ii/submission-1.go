func findOrder(numCourses int, prerequisites [][]int) []int {
    preq := make([][]int, numCourses)
	indeg := make([]int, numCourses)

	for _, vals := range prerequisites {
		preq[vals[1]] = append(preq[vals[1]], vals[0])
		indeg[vals[0]]++
	}

	res := []int{}

	for i := 0; i < numCourses; i++ {
		if indeg[i] == 0 {
			dfs(preq, i, &res, indeg)
		}
	}

	if len(res) == numCourses {
		return res
	}

	return []int{}
}

func dfs(preq [][]int, val int, res *[]int, indeg []int) {
	*res = append(*res, val)
	indeg[val]--
	for _, n := range preq[val] {
		indeg[n]--
		if indeg[n] == 0 {
			dfs(preq, n, res, indeg)
		}
	}	
}
