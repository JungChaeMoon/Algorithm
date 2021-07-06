def longest_common_prefix(strs):
    if len(strs) >= 2:
        common_prefix = ''
        new_common_prefix = ''
        for char1, char2 in zip(strs[0], strs[1]):
            if char1 == char2:
                common_prefix += char1
            else:
                break
        for i in range(2, len(strs)):
            for char1, char2 in zip(common_prefix, strs[i]):
                if char1 == char2:
                    new_common_prefix += char1
                else:
                    break
            if len(new_common_prefix) <= len(common_prefix):
                common_prefix = new_common_prefix
                new_common_prefix = ''
        return common_prefix
    else:
        return strs[0]


print(longest_common_prefix(["baab","bacb","b","cbc"]))