def plus_one(digits):
    idx = 1
    digits[-1] = digits[-1] + 1
    while digits[-idx] == 10:
        digits[-idx] = 0
        if idx == len(digits):
            digits.insert(0, 1)
            return digits
        digits[-idx - 1] = digits[-idx - 1] + 1
        idx += 1
    return digits


print(plus_one([9]))