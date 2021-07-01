class Solution:
    def reverse(self, x: int) -> int:
        while  x % 10 == 0 and x != 0:
            x = x // 10
        x = str(x)[::-1]
        if x[-1] == '-':
            x = list(x)
            x.insert(0, x.pop())
            x = ''.join(x)
        if -2**31 <= int(x) <= 2**31 -1:
            return int(x)
        else:
            return 0


def reverse_int(x):
    f = False
    z = 0
    if x < 0:
        x *= -1
        f = True
    while x % 10 == 0 and x != 0:
        x = x // 10
    start = 1
    length, end = len(str(x)) - 1, len(str(x)) - 1
    while start <= end + 1:
        z += x % (10 ** start) / (10 ** start) * (10 ** length)
        x -= (x % (10 ** start))
        start += 1
        length -= 1
    if f:
        z *= -1
    if -2 ** 31 <= int(z * 10) <= 2 ** 31 - 1:
        return int(z * 10)
    else:
        return 0
