import heapq


def solution(scoville, K):
    answer = 0
    _heapq = []
    for num in scoville:
        heapq.heappush(_heapq, num)

    while len(_heapq) > 2:
        flag = True
        for num in _heapq:
            if num < K:
                flag = False
                break
        if flag:
            break
        answer += 1
        first = heapq.heappop(_heapq)
        second = heapq.heappop(_heapq)
        new_scoville = first + (second * 2)
        heapq.heappush(_heapq, new_scoville)

    for num in _heapq:
        if num < K:
            return -1

    return answer

