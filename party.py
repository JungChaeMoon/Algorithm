import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)


n, m, arrival = map(int, input().split())
graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b, c = map(int, input().split())
    flag = False
    for idx, t in enumerate(graph[a]):
        if b == t[1]:
            if t[0] > c:
                graph[a][idx] = (c, b)
            flag = True
    if not flag:
        graph[a].append((c, b))


distance = [INF] * (n + 1)
visited = [False] * (n + 1)


def dijkstra(arrival):
    q = []
    distance[arrival] = 0
    visited[arrival] = True
    for dist, node in graph[arrival]:
        heapq.heappush(q, (dist, node))
        distance[node] = dist

    while q:
        dist, now = heapq.heappop(q)
        visited[now] = True
        for dist, node in graph[now]:
            cost = dist + distance[now]
            if distance[node] > cost and not visited[node]:
                distance[node] = cost
                heapq.heappush(q, (cost, node))

    return distance

answer = dijkstra(arrival)


for i in range(1, n + 1):
    if i == 2:
        pass
    distance = [INF] * (n + 1)
    visited = [False] * (n + 1)

    result = dijkstra(i)
    answer[i] += result[arrival]

answer[0] = 0
print(max(answer))
