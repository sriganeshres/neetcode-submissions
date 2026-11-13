func rob(nums []int) int {
    rob1, rob2 := 0,0

	for _, n := range nums {
		temp := n + rob1
		if rob2 > temp {
			temp = rob2
		}
		rob1 = rob2
		rob2 = temp
	}

	return rob2
}

