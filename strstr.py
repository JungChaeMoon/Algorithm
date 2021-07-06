def strstr(haystack, needle):
    if needle == "":
        return 0
    return haystack.find(needle)


def strstr2(haystack, needle):
    if needle == "":
        return 0
    needle_len = len(needle)
    for i in range(len(haystack)):
        if haystack[i: i + needle_len] == needle:
            return i
    return -1


print(strstr(haystack = "aaaaa", needle = "bba"))
print(strstr2(haystack = "hello", needle = "ll"))