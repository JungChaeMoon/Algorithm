class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        cur = head
        length = 1
        while True:
            if cur.next is None:
                break
            cur = cur.next
            length += 1
        cur = head

        if length == n:
            return head.next

        for i in range(length - n - 1):
            cur = cur.next
        cur.next = cur.next.next
        return head
