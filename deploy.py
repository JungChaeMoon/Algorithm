def solution(progresses, speeds):
    answer = 0
    result = []
    deploy = []
    possible_deploy = 100
    for progress, speed in zip(progresses, speeds):
        day, div = divmod(possible_deploy - progress, speed)
        if div > 0:
            day += 1
        deploy.append(day)

    length = len(deploy)
    pre_day = deploy[0]
    for i in range(length):
        next = deploy.pop(0)
        if pre_day >= next:
            answer += 1
        else:
            pre_day = next
            result.append(answer)
            answer = 1
    result.append(answer)

    return result

