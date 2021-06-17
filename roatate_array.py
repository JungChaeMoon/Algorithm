from collections import deque


def rotate(nums, k):
    deq = deque(nums)
    for _ in range(k):
        del_num = deq.pop()
        deq.appendleft(del_num)
    nums[:] = list(deq)
