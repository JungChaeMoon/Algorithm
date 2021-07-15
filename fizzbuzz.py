def fizzbuzz(n):
    fizzbuzz_list = []
    for i in range(1, 10 ** 4 + 1):
        if i % 15 == 0:
            fizzbuzz_list.append('FizzBuzz')
        elif i % 5 == 0:
            fizzbuzz_list.append('Buzz')
        elif i % 3 == 0:
            fizzbuzz_list.append('Fizz')
        else:
            fizzbuzz_list.append(str(i))
    return fizzbuzz_list[:n]


print(fizzbuzz(15))