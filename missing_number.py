def missing_number(nums):
    nums = sorted(nums)
    compare_num = 0
    for num in nums:
        if compare_num == num:
            compare_num += 1
        else:
            return compare_num
    return nums[-1] + 1


print(missing_number([9,6,4,2,3,5,7,0,1]))