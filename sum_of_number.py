import sys

input = sys.stdin.readline

N, M = map(int, input().split())
numbers = list(map(int, input().split()))

start = 0
end = 0
result = 0
count = 0

while start <= end:

    if M > result:
        if end < len(numbers):
            end += 1
            result += numbers[end - 1]
        else:
            while True:
                if start == end:
                    start+=1
                    break
                start += 1
                result -= numbers[start - 1]
                if result == M:
                    count += 1

    elif M < result:
        start += 1
        result -= numbers[start - 1]

    elif M == result:
        count += 1
        start += 1
        result -= numbers[start - 1]

print(count)
