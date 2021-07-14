def is_valid(s):
    stack = []
    pair = {
        ')': '(',
        ']': '[',
        '}': '{'
    }
    for char in s:
        if char not in pair:
            stack.append(char)
        else:
            if len(stack) == 0:
                return False
            else:
                close_bracket = stack.pop()
                if close_bracket != pair[char]:
                    return False
    if len(stack) >= 1:
        return False
    else:
        return True


print(is_valid('['))