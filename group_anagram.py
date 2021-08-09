def group_anagram(strs):
    dict_of_strs = {}
    res = {}
    for string in strs:
        sorted_string = ''.join(sorted(string))
        if dict_of_strs.setdefault(sorted_string, 0) == 0:
            res[sorted_string] = [string]
        else:
            res[sorted_string].append(string)
        dict_of_strs[sorted_string] += 1
    return [value for value in res.values()]


print(group_anagram(["a"]))
