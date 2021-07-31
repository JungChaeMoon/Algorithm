def hamming_weight(n):
    num = int(str(n), 2)
    count = 0
    while num:
        count += num & 1
        num >>= 1
    return count


print(hamming_weight('00000000000000000000000000001011'))
