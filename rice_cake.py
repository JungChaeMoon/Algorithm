import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
rice_cakes = list(map(int, sys.stdin.readline().rstrip().split()))
max_height = max(rice_cakes)

result = 0


def binary_search(rice_cakes, start, end):

    while start<=end:
        mid = (start + end) // 2
        answer = 0
        for rice_cake in rice_cakes:
            if rice_cake < mid:
                continue
            answer += (rice_cake - mid)

        if answer == M:
            return mid
        elif answer > M:
            start = mid + 1
        elif answer < M:
            result = mid
            end = mid - 1

print(result)

