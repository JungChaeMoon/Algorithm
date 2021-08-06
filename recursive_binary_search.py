def recursive_binary_search(nums, left, right, target):
    if left < right:
        mid = (left + right) // 2

        if target == nums[mid]:
            return mid
        elif target > nums[mid]:
            return recursive_binary_search(nums, mid + 1, right, target)
        else:
            return recursive_binary_search(nums, left, mid - 1, target)


print(recursive_binary_search([1,2,3,4,5,6,7], 0, 7, 6))