def generate(numRows):
    ret = [[1], [1, 1]]
    if numRows == 1:
        return [[1]]
    if numRows == 2:
        return [[1], [1, 1]]
    for i in range(2, numRows):
        row = [1]
        for j in range(len(ret[i - 1]) - 1):
            row.append(ret[i - 1][j] + ret[i - 1][j + 1])
        row.append(1)
        ret.append(row)
    return ret


print(generate(1))