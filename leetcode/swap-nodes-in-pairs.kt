package leetcode

import leetcode.utils.ListNode

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val first = ListNode(0)
        first.next = head
        var slow: ListNode? = first
        var fast = head.next
        while (fast != null) {
            swap(slow!!, fast)
            slow = slow.next?.next
            fast = slow?.next?.next
        }
        return first.next
    }

    fun swap(slow: ListNode, fast: ListNode) {
        slow.next!!.next = fast.next
        fast.next = slow.next
        slow.next = fast
    }
}