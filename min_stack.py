class MinStack:

    def __init__(self):
        self.stack = []

    def push(self, val: int) -> None:

        self.stack.append([val])

    def pop(self) -> None:
        del self.stack[-1]

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        min_value = self.stack[0][0]
        for val in self.stack:
            if min_value > val[0]:
                min_value = val[0]
        return min_value


# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
