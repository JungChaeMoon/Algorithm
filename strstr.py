def strstr(haystack, needle):
    index = haystack.find(needle)
    if index == -1:
        return 0
    else:
        return index


print(strstr(haystack = "aaaaa", needle = "bba"))