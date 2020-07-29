def solution(prices):
    answer = []
    for i in range(len(prices)):
        j = 0
        for j in range(i + 1, len(prices)):
            if prices[i] > prices[j]:
                break
        if i == len(prices) -1:
            answer.append(0)
            break
        answer.append(j-i)

    return answer

