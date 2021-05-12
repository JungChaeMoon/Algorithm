
m itertools import permutations


visited = [False] * 10000000


def make_prime_number(prime_num):

    for i in range(2, len(prime_num)):
        if prime_num[i]:
            for j in range(i*2, len(prime_num), i):
                prime_num[j] = False
    return prime_num


def find_prime_number(comb, prime_num):
    ret = 0
    for num in comb:
        if prime_num[int(''.join(num))] and not visited[int(''.join(num))]:
            ret += 1
            visited[int(''.join(num))] = True
    return ret


def solution(numbers):
    answer = 0
    prime_num = [False, False] + [True] * 10000000
    make_prime_number(prime_num)
    for i in range(1, len(list(numbers)) + 1):
        comb = permutations(list(numbers), i)
        answer += find_prime_number(comb, prime_num)
    return answer
