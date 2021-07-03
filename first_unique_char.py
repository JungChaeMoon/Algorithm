def first_unique_char(s):
    s_dict = {}
    for char in s:
        if char not in s_dict: s_dict[char] = 1
        else: s_dict[char] += 1
    for key, value in s_dict.items():
        if value == 1:
            return s.find(key)
    return -1


print(first_unique_char("loveleetcode"))