array = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]


def binary_search(array, target, start, end):

    if start > end:
        return None

    mid = (start + end) // 2

    if array[mid] == target:
        return mid

    if array[mid] < target:
        return binary_search(array, target, mid+1, end)
    elif array[mid] > target:
        return binary_search(array, target, start, mid-1)


print(binary_search(array, 4, 0, 9))
