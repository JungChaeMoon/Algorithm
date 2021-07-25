def rob(nums):
    if len(nums) == 1:
        return nums[0]

    dp = [-1] * len(nums)
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for i in range(2, len(nums)):
        dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
    return dp[-1]

print(rob([1,2,3,1]))