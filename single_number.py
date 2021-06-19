def single_number(nums):
    dup_dict = {}
    for num in nums:
        if num not in dup_dict:
            dup_dict[num] = 1
        else:
            dup_dict[num] += 1
    for key, value in dup_dict.
        if value == 1:
            return key

print(single_number([2,2,1]))