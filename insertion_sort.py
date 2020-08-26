array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    for j in range(i, len(array)):
        if i == array[j]:
            array[i], array[j] = array[j], array[i]
            break

print(array)
