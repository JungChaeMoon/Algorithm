

def palindrome_index(s):
    if s == s[::-1]:
        return -1
    left = 0
    right = len(s) - 1
    while left <= right:
        if s[left] == s[right]:
            left, right = left + 1, right - 1
        else:
            if s[left + 1] == s[right] and s[left + 2] == s[right -1]:
                return left
            elif s[left] == s[right - 1] and s[left + 1] == s[right -2]:
                return right




print(palindrome_index('aaa'))
