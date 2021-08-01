from collections import deque


def rotLeft(a, d):
    a = deque(a)
    for _ in range(d):
        i = a.popleft()
        a.append(i)
    return a