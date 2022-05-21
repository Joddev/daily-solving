package leetcode

import leetcode.utils.ListNode

class RemoveDuplicatesFromSortedList {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var prev = head
        var cur = head?.next

        while(cur != null) {
            if (prev!!.`val` == cur.`val`) {
                prev.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }

        return head
    }
}