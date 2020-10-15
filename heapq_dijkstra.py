import heapq
import sys

INF = int(1e9)
input = sys.stdin.readline
n, m  = map(int, input().split())
start = int(input())

graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)
visited = [False] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist, node = heapq.heappop(q)
    distance[start] = dist
    visited[node] = True
    now = node
    for i in graph[now]:
        distance[i[0]] = i[1]
        heapq.heappush(q, (i[1], i[0]))

    while q:
        dist, node = heapq.heappop(q)
        if not visited[node]:
            visited[node] = True
            for j in graph[node]:
                cost = dist + j[1]
                if distance[j[0]] > cost:
                    distance[j[0]] = cost
                    heapq.heappush(q, (cost, j[0]))

dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])


