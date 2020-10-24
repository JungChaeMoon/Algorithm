import sys
import heapq


input = sys.stdin.readline
INF = int(1e9)
dir_x = [-1, 1, 0, 0]
dir_y = [0, 0, 1, -1]
queue = []


def dijkstra(graph, distance, q, N):
    init = 0
    x = init
    y = init
    heapq.heappush(q, (graph[init][init], init, init))
    distance[init][init] = 0
    while q:
        cost, start, end = heapq.heappop(q)

        for i in range(4):
            next_x = start + dir_x[i]
            next_y = end + dir_y[i]
            if 0 <= next_x < N and 0 <= next_y < N:
                next_cost = graph[next_x][next_y] + cost
                if next_cost < distance[next_x][next_y]:
                    distance[next_x][next_y] = next_cost
                    heapq.heappush(q, (next_cost, next_x, next_y))

count = 0
while True:
    count += 1
    N = int(input())
    graph = []
    visited = []
    distance = []
    heap = []
    if N == 0:
        break
    for _ in range(N):
        row = list(map(int, input().split()))
        graph.append(row)
        visited.append([False] * N)
        distance.append([INF] * N)

    dijkstra(graph, distance, heap, N)
    print('Problem {}: {}'.format(count, distance[N-1][N-1]))
