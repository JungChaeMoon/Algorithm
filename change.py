import sys

N, K = map(int, sys.stdin.readline().split())

A = list(map(int, sys.stdin.readline().split()))
B = list(map(int, sys.stdin.readline().split()))

A = sorted(A)
B = sorted(B, reverse=True)

for i in range(K):
    A[i] = B[i]

result = 0
for num in A:
    result += num

print(result)
