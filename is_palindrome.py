def is_palindrome(s):
    s = ''.join([char.lower() for char in s if char.isalnum()])
    left = 0
    right = len(s) - 1
    while left <= right:
        if s[left] != s[right]:
            return False
        else:
            left += 1
            right -= 1
    return True


print(is_palindrome("race a car"))