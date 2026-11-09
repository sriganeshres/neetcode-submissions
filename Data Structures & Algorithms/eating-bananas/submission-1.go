func minEatingSpeed(piles []int, h int) int {
	l := 1
	r := 0
	for _, p := range piles {
       if p > r {
           r = p
        }
    }
	min_rate := r
	for l <= r {
		mid := (l + r) / 2;
		t := 0
		for _, vals := range piles {
			t += int(math.Ceil(float64(vals) / float64(mid)))
		}
		if t <= h {
			min_rate = mid
			r = mid - 1
		} else {
			l = mid + 1
		}
	}

	return min_rate
}
