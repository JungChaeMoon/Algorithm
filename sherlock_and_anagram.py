##########TIME OUT############
def sherlock_and_anagrams(s):
    length = len(s)
    sliced = 1
    res = 0
    while sliced < length:
        for i in range(length):
            for j in range(i + 1, length):
                if sorted(s[i: i + sliced]) == sorted(s[j: j + sliced]):
                    res += 1
        sliced += 1
    return res


print(sherlock_and_anagrams('ifailuhkqq'))