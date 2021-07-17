def roman_to_integer(s):
    roman_symbol = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000,
    }
    pre = s[0]
    result = []
    for char in s:
        if pre == 'I' and (char == 'V' or char == 'X'):
            result[-1] = - result[-1]
        elif pre == 'X' and (char == 'L' or char == 'C'):
            result[-1] = - result[-1]
        elif pre == 'C' and (char == 'D' or char == 'M'):
            result[-1] = - result[-1]
        result.append(roman_symbol[char])
        pre = char
    return sum(result)


print(roman_to_integer('MCMXCIV'))


