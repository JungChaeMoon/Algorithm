from collections import Counter


def two_strings(s1, s2):
    return 'NO' if Counter(s1) - Counter(s2) == Counter(s1) else 'Yes'


print(two_strings('hi', 'world'))