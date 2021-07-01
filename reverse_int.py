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
