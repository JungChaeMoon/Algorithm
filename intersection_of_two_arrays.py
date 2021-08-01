from collections import Counter


# def intersect(nums1, nums2):
#     result = []
#     for num in nums1:
#         if num in nums2:
#             nums2.remove(num)
#             result.append(num)
#     return result

def intersect(nums1, nums2):
    dict_of_nums1 = dict(Counter(nums1))
    result = []
    for num in nums2:
        if num in dict_of_nums1 and dict_of_nums1[num] > 0:
            dict_of_nums1[num] -= 1
            result.append(num)
    return result



print(intersect([4,9,5], [9,4,9,8,4]))

