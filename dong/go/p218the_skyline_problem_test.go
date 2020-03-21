package main

import (
	"fmt"
	"testing"
)

func TestGetSkyline(t *testing.T) {
	//var building = [][]int{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}}
	//fmt.Println(getSkyline(building))

	building := [][]int{{0, 2, 3}, {2, 5, 3}}
	fmt.Println(getSkyline(building))
}
