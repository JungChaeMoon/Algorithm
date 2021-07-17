def count_primes(n):
    prime_list = [True] * n
    for i in range(2, len(prime_list)):
        if not prime_list[i]:
            continue
        for j in range(i + i, len(prime_list), i):
            prime_list[j] = False
    return prime_list[2: n].count(True)


print(count_primes(6))

