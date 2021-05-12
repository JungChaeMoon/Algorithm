import heapq


def lastStoneWeight(weights):
    weights = list(map(lambda x:-x, weights))
    heapq.heapify(weights)
    while len(weights) > 1:
        stone1 = heapq.heappop(weights)
        stone2 = heapq.heappop(weights)
        remain = abs(stone1 - stone2)
        heapq.heappush(weights, -remain)
        if remain == 0:
            continue

    if len(weights) == 0:
        return 0
    return -heapq.heappop(weights)


if __name__ == '__main__':
    for i in range(2, 5):
        f = open(f'/Users/chaemoon/Downloads/input00{i}.txt', 'r')
        test = []
        for idx, x in enumerate(f):
            if idx == 0:
                continue
            test.append(int(x.rstrip()))
        print(lastStoneWeight(test))
    # print(lastStoneWeight([1,2,3,6,7,7]))

