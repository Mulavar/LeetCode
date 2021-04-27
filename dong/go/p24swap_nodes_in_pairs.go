package main

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	shim := new(ListNode)
	shim.Next = head
	pre := shim
	node := head
	next := head.Next

	for node != nil && next != nil {
		// pre - node - next
		// pre - next - node
		pre.Next = next
		node.Next = next.Next
		next.Next = node
		pre = node
		node = pre.Next
		if node != nil {
			next = node.Next
		}

	}

	return shim.Next
}
