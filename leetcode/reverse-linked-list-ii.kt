package leetcode

import leetcode.utils.ListNode

class ReverseLinkedListII {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) return head

        val begin = ListNode(0)
        begin.next = head
        var cnt = 0
        var cur = begin
        while (cnt < left - 1) {
            cur = cur.next!!
            cnt++
        }
        val start = cur
        val last = cur.next!!
        var a = last
        var b = last.next!!
        while (cnt < right - 1) {
            val tmp = b.next!!
            b.next = a
            a = b
            b = tmp
            cnt++
        }
        start.next = a
        last.next = b
        return begin.next
    }
}