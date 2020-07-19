def solution(clothes):
    clothes_dict = dict()
    for _, clothe in clothes:
        if clothe in clothes_dict.keys():
            clothes_dict[clothe] += 1
        else:
            clothes_dict[clothe] = 1

    answer = 1
    for value in clothes_dict.values():
        answer *= (value + 1) #안입는 경우

    return answer - 1

