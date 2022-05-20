package leetcode

import leetcode.utils.ListNode

class RemoveDuplicatesFromSortedListII {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val begin = ListNode(-101)
        var slow = begin
        var start: ListNode = head
        var end = head

        while (end != null) {
            if (start.`val` == end.`val`) {
                end = end.next
                continue
            }

            if (start.next == end) {
                slow.next = start
                slow = start
                slow.next = null
            }
            start = end
        }

        if (start.next == null) {
            slow.next = start
        }

        return begin.next
    }
}