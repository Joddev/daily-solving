package leetcode

import leetcode.utils.ListNode

class PartitionList {
    fun partition(head: ListNode?, x: Int): ListNode? {
        val lessHead = ListNode(0)
        val greaterHead = ListNode(0)
        var less = lessHead
        var greater = greaterHead

        var cur = head
        while (cur != null) {
            if (cur.`val` < x) {
                less.next = cur
                less = cur
            } else {
                greater.next = cur
                greater = cur
            }
            cur = cur.next
        }
        greater.next = null
        less.next = greaterHead.next
        return lessHead.next
    }
}