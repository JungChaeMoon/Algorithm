def max_profit_dp(prices):

    min_price, max_profit = 10 ** 4 + 1, 0
    for i in range(len(prices)):
        if prices[i] < min_price:
            min_price = prices[i]
        elif prices[i] - min_price > max_profit:
            max_profit = prices[i] - min_price
    return max_profit


print(max_profit_dp([2, 1, 2, 0, 1]))
