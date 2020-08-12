def solution(array, commands):
    answer = []
    for command in commands:
        arr = array[command[0]-1: command[1]]
        print(arr)
        arr = sorted(arr)
        answer.append(arr[command[2]-1])
    return answer
