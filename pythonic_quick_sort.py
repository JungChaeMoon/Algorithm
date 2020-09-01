# pythonic qucik sort

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]


def quick_sort(array):
    if len(array) <= 0:
        return []
    pivot = array[0]
    left = 0
    tail = array[left:]

    left_tail = [i for i in tail if i < pivot]
    right_tail = [i for i in tail if i > pivot]

    return quick_sort(left_tail) + [pivot] + quick_sort(right_tail)


print(quick_sort(array))
