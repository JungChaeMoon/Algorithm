def count_and_say(n):
    count_list = ['1']
    start = 2
    while start <= n:
        pre = ''
        cnt = 0
        count_say = []
        for char in count_list[start - 2]:
            if pre == char:
               cnt += 1
            else:
                if pre != '':
                    count_say.append((cnt, pre))
                pre = char
                cnt = 1
        result = ''
        count_say.append((cnt, pre))
        for cnt, pre in count_say:
            result += (str(cnt) + pre)
        count_list.append(result)
        start += 1
    return count_list[-1]


print(count_and_say(4))