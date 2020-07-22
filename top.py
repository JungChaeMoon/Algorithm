import collections


def solution(heights):
    DUMMY = 0
    top = collections.deque([DUMMY])
    for send in range(len(heights)-1, 0, -1):
        flag = True
        for receive in range(send-1 , -1, -1):
            if heights[send] < heights[receive]:
                top.appendleft(receive+1)
                break
            if receive == 0:
                flag = False
        if not flag:
            top.appendleft(DUMMY)

    top.pop()
    while len(top) != len(heights) : top.appendleft(DUMMY)

    return list(top)
