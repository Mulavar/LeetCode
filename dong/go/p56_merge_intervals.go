package main

import (
	"sort"
)

type intss [][]int

func (arr intss) Less(i, j int) bool {
	return arr[i][0] <= arr[j][0]
}

func (arr intss) Swap(i, j int) {
	arr[i], arr[j] = arr[j], arr[i]
}

func (arr intss) Len() int {
	return len(arr)
}

func merge(intervals [][]int) [][]int {
	if len(intervals) <= 1 {
		return intervals
	}
	result := make([][]int, 0)
	var intsP intss = intervals
	sort.Sort(intsP)

	left := intsP[0][0]
	right := intsP[0][1]
	count := 0
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] > right {
			intervals[count][0] = left
			intervals[count][1] = right
			count++
			left = intervals[i][0]
			right = intervals[i][1]
		} else if intervals[i][1] > right {
			right = intervals[i][1]
		}
	}
	intervals[count][0] = left
	intervals[count][1] = right
	count++

	for i := 0; i < count; i++ {
		result = append(result, intervals[i])
	}

	return result
}
