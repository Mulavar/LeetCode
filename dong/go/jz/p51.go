package jz

func reversePairs(nums []int) int {
	return merge(nums, 0, len(nums)-1)
}

func merge(nums []int, left, right int) (count int) {
	if left >= right {
		return 0
	}

	mid := left + (right-left)/2
	lCount := merge(nums, left, mid)
	rCount := merge(nums, mid+1, right)

	idxLeft := left
	idxRight := mid + 1

	tmpNums := make([]int, right-left+1)
	idx := 0
	for idxLeft <= mid || idxRight <= right {
		if idxLeft > mid {
			tmpNums[idx] = nums[idxRight]
			idxRight++
		} else if idxRight > right {
			tmpNums[idx] = nums[idxLeft]
			idxLeft++
		} else {
			if nums[idxLeft] <= nums[idxRight] {
				tmpNums[idx] = nums[idxLeft]
				idxLeft++
			} else {
				tmpNums[idx] = nums[idxRight]
				count += mid - idxLeft + 1
				idxRight++
			}
		}
		idx++
	}

	for i := left; i <= right; i++ {
		nums[i] = tmpNums[i-left]
	}

	return count + lCount + rCount
}
