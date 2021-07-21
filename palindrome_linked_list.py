# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        cur = head
        length = 1
        while True:
            if cur is None:
                break
            cur = cur.next
            length += 1

        cur = head
        prev = head

        for i in range(length // 2):
            cur = cur.next
            if i == (length // 2 - 1):
                prev.next = None
                break
            prev = prev.next

        if length == 2:
            return True

        prev = cur
        cur = cur.next
        prev.next = None

        while True:
            if cur is None:
                cur = prev
                break
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp

        for _ in range(length // 2):
            if head.val != cur.val:
                return False
            else:
                if cur.next is None and head.next is not None:
                    return True
                head = head.next
                cur = cur.next
        return True