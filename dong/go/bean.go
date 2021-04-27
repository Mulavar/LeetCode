package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func (node *ListNode) String() string{
	return fmt.Sprintf("{value: %d, next: %v}", node.Val, node.Next)
}
