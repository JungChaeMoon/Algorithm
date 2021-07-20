# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None:
            return None
        elif head.next is None:
            return head
        elif head.next.next is None:
            prev = head
            head = head.next
            head.next = prev
            prev.next = None
            return head
        else:
            cur = head.next.next
            prev = head
            head = head.next
            prev.next = None
            while True:
                if cur.next is None:
                    head.next = prev
                    cur.next = head
                    head = cur
                    return head
                head.next = prev
                prev = head
                head = cur
                cur = cur.next
