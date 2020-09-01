array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]


def solution(array):
    result = []
    max_num = max(array)
    count = [0] * (max_num + 1)
    for num in array:
        count[num] += 1

    for idx, num in enumerate(count):
        for _ in range(num):
            result.append(idx)

    return result

print(solution(array))

