package main

import (
	"container/heap"
)

type line [][]int

func (l line) Swap(i, j int) {
	l[i], l[j] = l[j], l[i]
}

func (l line) Less(i, j int) bool {
	if l[i][0] != l[j][0] {
		return l[i][0] < l[j][0]
	} else {
		return l[i][1] > l[j][1]
	}
}

func (l line) Len() int {
	return len(l)
}

func (l *line) Push(val interface{}) {
	*l = append(*l, val.([]int))
}

func (l *line) Pop() interface{} {
	n := len(*l)
	x := (*l)[n-1]
	*l = (*l)[0 : n-1]
	return x
}

type height []int

func (h height) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h height) Less(i, j int) bool {
	return h[j] < h[i]
}

func (h height) Len() int {
	return len(h)
}

func (h *height) Push(val interface{}) {
	*h = append(*h, val.(int))
}

func (h *height) Pop() interface{} {
	n := len(*h)
	x := (*h)[n-1]
	*h = (*h)[0 : n-1]
	return x
}

func getSkyline(buildings [][]int) [][]int {
	linesHeap := make(line, 0)
	for _, building := range buildings {
		left := make([]int, 2, 2)
		left[0] = building[0]
		left[1] = building[2]
		right := make([]int, 2, 2)
		right[0] = building[1]
		right[1] = -building[2]
		heap.Push(&linesHeap, left)
		heap.Push(&linesHeap, right)
	}
	heap.Init(&linesHeap)

	var result = make([][]int, 0)
	//扫描到了左边还没扫描到右边
	heights := make(height, 0)
	heap.Init(&heights)
	for len(linesHeap) > 0 {
		line := heap.Pop(&linesHeap).([]int)
		var curMaxH int
		var lastMaxH int

		// 找出已扫描了左线还没扫描到右线的所有building的最大高度
		if line[1] > 0 {
			// building左边的线
			if len(heights) > 0 {
				lastMaxH = heights[0]
			} else {
				lastMaxH = 0
			}
			heap.Push(&heights, line[1])
			curMaxH = heights[0]
		} else {
			lastMaxH = heights[0]
			//remove use index
			for i := 0; i < len(heights); i++ {
				if heights[i] == -line[1] {
					heap.Remove(&heights, i)
					break
				}
			}
			if len(heights) > 0 {
				curMaxH = heights[0]
			} else {
				curMaxH = 0
			}
		}

		if curMaxH != lastMaxH {
			result = append(result, []int{line[0], curMaxH})
		}

	}

	return result
}

// 线段树
func getSkyline1(buildings [][]int) [][]int {
	len := len(buildings)
	if len == 0 {
		return nil
	}
	return segment(buildings, 0, len-1)
}

func segment(buildings [][]int, l int, r int) [][]int {
	// 创建返回值
	var res [][]int
	// 结束条件
	if l == r {
		return [][]int{{buildings[l][0], buildings[l][2]}, {buildings[l][1], 0}}
	}
	// 取中间值
	mid := l + (r-l)/2
	// 左递归
	left := segment(buildings, l, mid)
	// 右递归
	right := segment(buildings, mid+1, r)
	// 左右合并
	// 创建left 和 right 的索引位置
	var m int = 0
	var n int = 0
	// 创建 left 和 right 的目前高度
	var lpre int = 0
	var rpre int = 0
	for m < len(left) || n < len(right) {
		// 一边遍历完，则全部添加另一边
		if m >= len(left) {
			res = append(res, right[n])
			n++
		} else if n >= len(right) {
			res = append(res, left[m])
			m++
		} else { // swip line
			if left[m][0] < right[n][0] {
				if left[m][1] > rpre {
					res = append(res, left[m])
				} else if lpre > rpre {
					res = append(res, []int{left[m][0], rpre})
				}
				lpre = left[m][1]
				m++
			} else if right[n][0] < left[m][0] {
				if right[n][1] > lpre {
					res = append(res, right[n])
				} else if rpre > lpre {
					res = append(res, []int{right[n][0], lpre})
				}
				rpre = right[n][1]
				n++
			} else { // left 和 right横坐标相等
				if left[m][1] >= right[n][1] && left[m][1] != max(lpre, rpre) {
					res = append(res, left[m])
				} else if left[m][1] <= right[n][1] && right[n][1] != max(lpre, rpre) {
					res = append(res, right[n])
				}
				lpre = left[m][1]
				rpre = right[n][1]
				m++
				n++
			}
		}
	}
	return res
}

func max(l, r int) int {
	if l > r {
		return l
	}
	return r
}
