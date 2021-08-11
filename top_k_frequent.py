from collections import Counter


def top_k_frequent(nums, k):
    dict_of_nums = dict(Counter(nums))
    dict_of_nums = sorted(dict_of_nums.items(), key=lambda items: items[1], reverse=True)
    ret = []
    for i in range(k):
        ret.append(dict_of_nums[i][0])
    return ret

print(top_k_frequent([1,1,1,2,2,3], 2))