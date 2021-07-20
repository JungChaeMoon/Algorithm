# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        ret = ListNode()
        head = ret
        val = -101
        if l1 is None and l2 is None:
            return None
        elif l1 is None and l2 is not None:
            return l2
        elif l1 is not None and l2 is None:
            return l1

        if l1.val >= l2.val:
            val = l2.val
        else:
            val = l1.val
        while l1 is not None or l2 is not None:
            if l1 is None:
                ret.next = l2
                break
            elif l2 is None:
                ret.next = l1
                break
            if val - l1.val >= val - l2.val:
                ret.next = l1
                val = l1.val
                l1 = l1.next
            else:
                ret.next = l2
                val = l2.val
                l2 = l2.next
            ret = ret.next
        return head.next
