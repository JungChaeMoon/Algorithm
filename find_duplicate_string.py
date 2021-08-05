from collections import Counter


def find_duplicate_string(s):
    char_of_dict = dict(Counter(s))
    for char in s:
        if char_of_dict[char] == 1:
            return char


print(find_duplicate_string('teeter'))