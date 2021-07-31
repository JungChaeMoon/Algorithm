def reverse_bit(n):
    n = bin(n)[2:]
    while len(n) != 32:
        n = '0' + n
    result = ''
    for i in range(len(n) - 1, -1, -1):
        result += n[i]
    return int(result, 2)

print(reverse_bit('00000010100101000001111010011100'))