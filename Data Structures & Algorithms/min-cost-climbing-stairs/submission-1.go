func minCostClimbingStairs(cost []int) int {
    n := len(cost)
	dp := make([]int, n + 1)
	for i := range dp {
		dp[i] = -1
	}
	dp[n] = cost[n-1]
	idx0, idx1 := f(1, dp, cost), f(2, dp, cost)
	if idx0 < idx1 {
		return idx0
	}
	return idx1
}

func f(n int, dp, cost []int) int{
	if n >= len(dp) {
		return 0
	}

	if dp[n] != -1 {
		return dp[n]
	}

	idx0, idx1 := f(n + 1, dp, cost), f(n + 2, dp, cost)
	if idx0 < idx1 {
		dp[n] = cost[n-1] + idx0
		return dp[n]
	}
	dp[n] = cost[n-1] + idx1
	return dp[n]
}
