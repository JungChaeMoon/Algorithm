def max_sub_array(nums):
    dp = []
    max_num = nums[0]
    dp.append(max_num)

    for i in range(1, len(nums)):
        cur = nums[i]
        dp.append(max(cur, cur + dp[i - 1]))
        if dp[i] > max_num:
            max_num = dp[i]
    return max_num


print(max_sub_array([5, 4, -1, 7, 8]))
