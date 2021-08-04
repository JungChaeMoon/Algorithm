from collections import Counter, defaultdict


def count_triplets(arr, r):
    total = 0
    small, large = defaultdict(int), dict(Counter(arr))
    for num in arr:
        large[num] -= 1
        if num % r == 0:
            total += large[num * r] * small[num // r]
        small[num] += 1
    return total


print(count_triplets([1, 3, 9, 9, 27, 81], 3))