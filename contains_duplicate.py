def contain_duplicate(nums):
    if len(set(nums)) != len(nums): return True
    else: return False