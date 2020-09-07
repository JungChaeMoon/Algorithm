import sys

N = int(sys.stdin.readline().rstrip())

part = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(sys.stdin.readline().rstrip())

find_part = list(map(int, sys.stdin.readline().rstrip().split()))


def binary_search(target, start, end):
    mid = (start + end) // 2

    if start > end:
        return False

    if part[mid] == target:
        return mid
    elif part[mid] > target:
        return binary_search(target, start, mid - 1)
    elif part[mid] < target:
        return binary_search(target, mid+1, end)


for num in find_part:
    if not binary_search(num, 0, 4):
        print("no ", end='')
    else:
        print("yes ", end='')

