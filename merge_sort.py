def merge_sort(nums):
    if len(nums) > 1:
        mid = len(nums) // 2
        left_nums = nums[:mid]
        right_nums = nums[mid:]

        merge_sort(left_nums)
        merge_sort(right_nums)

        i = 0
        j = 0

        k = 0

        while i < len(left_nums) and j < len(right_nums):
            if left_nums[i] < right_nums[j]:
                nums[k] = left_nums[i]
                i += 1
            else:
                nums[k] = right_nums[j]
                j += 1
            k += 1

        #남았을 경우
        while i < len(left_nums):
            nums[k] = left_nums[i]
            i += 1
            k += 1

        while j < len(right_nums):
            nums[k] = right_nums[j]
            j += 1
            k += 1
    return nums


print(merge_sort([54,26,93,17,77,31,44,55,20]))
