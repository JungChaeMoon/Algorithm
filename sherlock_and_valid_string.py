from collections import Counter


def string_constructions(s):
    dict_of_s = dict(Counter(s))
    min_val = float('inf')
    a = sorted(dict_of_s.values())
    sliced = []
    res = 0
    for idx, value in enumerate(a):
        if min_val != value:
            min_val = value
            res += 1
            sliced.append(len(a[:idx]))
    sliced.append(len(a[sliced[-1]: -1]) + 1)
    if res >= 3 or sliced[-1] >= 2:
        return 'NO'
    return 'YES'



print(string_constructions('aabbcd'))