package main

import (
	"github.com/magiconair/properties/assert"
	"testing"
)

func TestMergeIntervals(t *testing.T) {
	datas := [][]int{{3, 4}, {1, 3}}
	result := merge(datas)
	assert.Equal(t, result, [][]int{{1, 4}})
}
