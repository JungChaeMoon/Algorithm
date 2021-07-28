def max_profit(prices):
    profits = []
    if len(prices) < 2:
        return 0
    for i in range(len(prices) - 1):
        profits.append(prices[i + 1] - prices[i])
    result = 0
    for profit in profits:
        if profit > 0:
            result += profit
    return result


print(max_profit([1, 2, 3, 4, 5]))