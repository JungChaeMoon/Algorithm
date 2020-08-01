def solution(n, lost, reserve):
    answer = n-len(lost)
    _lost = []
    for num in lost:
        if num in reserve:
            answer += 1
            reserve.remove(num)
            _lost.append(num)
    for num in _lost:
        lost.remove(num)
    for num in lost:
        if num-1 in reserve:
            answer += 1
            reserve.remove(num-1)
            continue

        if num+1 in reserve:
            answer += 1
            reserve.remove(num+1)

    return answer

