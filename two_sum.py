def two_sum(nums, target):
    dic = {}
    for idx, num in enumerate(nums):
        if num not in dic:
            dic[num] = [idx]
        else:
            dic[num].append(idx)
    for key, value in dic.items():
        if target - key in dic:
            if len(value) >= 2:
                return value
            else:
                if key != target -key:
                    return value + dic[target-key]

print(two_sum([3,2,4], 6))