package main

func longestConsecutive(nums []int) int {
	set := make(map[int]bool)
	for _, num := range nums {
		set[num] = true
	}

	result := 0
	for num, _ := range set {
		if _, exist := set[num-1]; exist{
			continue
		}

		count := 0
		for set[num] {
			num++
			count++
		}

		if result < count {
			result = count
		}
	}

	return result
}