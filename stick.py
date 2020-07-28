def solution(arrangement):
    answer = 0
    stack = []
    result = 0
    is_con = True
    for brace in arrangement:
        if brace == '(':
            stack.append('(')
            answer += 1
            is_con = True
        else:
            if not is_con:
                result += 1
                stack.pop()
                answer -= 1
                continue
            stack.pop()
            answer -= 1
            result += answer

            is_con = False

    return answer

