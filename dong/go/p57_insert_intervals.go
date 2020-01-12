package main

func insert(intervals [][]int, newInterval []int) [][]int {
	allIntervals := make([][]int, 0)
	inserted := false
	if len(intervals) == 0 {
		allIntervals = append(allIntervals, newInterval)
	}
	for i := 0; i < len(intervals); i++ {
		if intervals[i][0] > newInterval[0] && !inserted {
			allIntervals = append(allIntervals, newInterval)
			i--
			inserted = true
		} else {
			allIntervals = append(allIntervals, intervals[i])
		}
	}
	if !inserted {
		allIntervals = append(allIntervals, newInterval)
	}

	left := allIntervals[0][0]
	right := allIntervals[0][1]
	count := 0
	for i := 1; i < len(allIntervals); i++ {
		if allIntervals[i][0] > right {
			allIntervals[count][0] = left
			allIntervals[count][1] = right
			count++
			left = allIntervals[i][0]
			right = allIntervals[i][1]
		} else if allIntervals[i][1] > right {
			right = allIntervals[i][1]
		}
	}
	allIntervals[count][0] = left
	allIntervals[count][1] = right
	count++

	result := make([][]int, 0)
	for i := 0; i < count; i++ {
		result = append(result, allIntervals[i])
	}

	return result
}
