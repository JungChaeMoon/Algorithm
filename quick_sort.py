array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array, start, end):
    if start >= end:
        return
    pivot = start
    left = start + 1
    right = end
    while left <= right:

        while left <= end and array[left] <= array[pivot]:
            left = left + 1

        while start < right and array[pivot] <= array[right]:
            right = right - 1

        if left > right:
            array[pivot], array[right] = array[right], array[pivot]
        else:
            array[left], array[right] = array[right], array[left]

    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)


quick_sort(array, 0, len(array)-1)
print(array)


def quick_sort(nums):
    if len(nums) <= 1:
        return nums

    pivot = nums[len(nums) // 2]
    left, equal, right = [], [], []
    for num in nums:
        if pivot < num:
            right.append(num)
        elif pivot > num:
            left.append(num)
        else:
            equal.append(num)
    return quick_sort(left) + equal + quick_sort(right)


print(quick_sort([54, 26, 93, 17, 77, 31, 44, 55, 20]))

