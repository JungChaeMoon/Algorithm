##########TIME OUT############
# def sherlock_and_anagrams(s):
#     length = len(s)
#     sliced = 1
#     res = 0
#     while sliced < length:
#         for i in range(length):
#             for j in range(i + 1, length):
#                 if sorted(s[i: i + sliced]) == sorted(s[j: j + sliced]):
#                     res += 1
#         sliced += 1
#     return res


def sherlock_and_anagrams(s):
    res = 0
    dict_of_anagrams = {}
    for i in range(1, len(s)):
        for j in range(len(s) - i + 1):
            words = s[j:j + i]
            key = ''.join(sorted(words))
            res += dict_of_anagrams.setdefault(key, 0)
            dict_of_anagrams[key] += 1
    return res


print(sherlock_and_anagrams('kkkk'))


print(sherlock_and_anagrams('ifailuhkqq'))