def count_string(s):
    start = s[0]
    count = 0
    result = ''
    for char in s:
        if start == char:
            count += 1
        else:
            result += start + str(count)
            start = char
            count = 1


print(count_string("aaaabbbcccc"))