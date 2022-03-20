package leetcode

import leetcode.utils.ListNode

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var (a, b) = list1 to list2
        var head = ListNode(0)
        var cur: ListNode = head
        while (a != null && b != null) {
            if (a.`val` < b.`val`) {
                cur.next = a
                a = a.next
            } else {
                cur.next = b
                b = b.next
            }
            cur = cur.next!!
        }
        if (a != null) {
            cur.next = a
        } else {
            cur.next = b
        }
        return head.next
    }
}