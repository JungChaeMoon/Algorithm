def move_zeros(nums):
    check = []
    i = 0
    for idx, num in enumerate(nums):
        if num == 0:
            check.append(idx)
    for num in check:
        del nums[num - i]
        nums.append(0)
        i+= 1

print(move_zeros([0,1,0,3,12]))