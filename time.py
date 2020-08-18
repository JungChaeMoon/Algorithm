def solution(number):
    answer = 0
    for i in range(0,number+1):
        for j in range(0,60):
            for k in range(0,60):
                time = str(i).zfill(2) + str(j).zfill(2) + str(k).zfill(2)

                if str(number) in time: answer += 1


    return answer


if __name__=="__main__":
    number = int(input())
    print(solution(number))

