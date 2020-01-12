package main

import (
	"github.com/magiconair/properties/assert"
	"testing"
)

func TestInsertIntervals(t *testing.T) {
	datas := [][]int{{1, 2}, {3, 4}}
	result := insert(datas, []int{2, 3})
	assert.Equal(t, result, [][]int{{1, 4}})
}
