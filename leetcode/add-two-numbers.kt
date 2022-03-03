package leetcode

class ListNode(var `val`: Int) {
   var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var a = l1
    var b = l2
    var overload = 0
    var ret = ListNode(0)
    var cur = ret
    while (a != null || b != null) {
        val value = a.getValue() + b.getValue() + overload
        cur.next = ListNode(value % 10)
        overload = value / 10
        cur = cur.next!!
        a = a?.next
        b = b?.next
    }
    if (overload > 0) {
        cur.next = ListNode(1)
    }
    return ret.next
}

fun ListNode?.getValue(): Int = this?.`val` ?: 0
