def hamming_distance(x, y):
    return bin(x^y).count('1')