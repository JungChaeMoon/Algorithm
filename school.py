import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())
graph = [[] * (N+1) for _ in range(N+1)]
visited = [False] * (N+1)
distance = [INF] * (N+1)

for _ in range(M+1):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))


answer = 0


def best_prim(start):
    global answer
    answer = 0
    q = []
    visited[start] = True
    distance[start] = 0

    for node, cost in graph[start]:
        heapq.heappush(q, (-cost, node))

    while q:
        cost, node = heapq.heappop(q)
        if not visited[node]:
            visited[node] = True
            if not cost:
                answer += 1
            for end, cost in graph[node]:
                if not visited[end]:
                    heapq.heappush(q, (-cost, end))
    return answer


def worst_prim(start):
    global answer
    answer = 0
    q = []
    visited[start] = True
    distance[start] = 0

    for node, cost in graph[start]:
        heapq.heappush(q, (cost, node))

    while q:
        cost, node = heapq.heappop(q)
        if not visited[node]:
            visited[node] = True
            if not cost:
                answer += 1
            for end, cost in graph[node]:
                if not visited[end]:
                    heapq.heappush(q, (cost, end))

    return answer


best = best_prim(0) ** 2
visited = [False] * (N+1)
distance = [INF] * (N+1)
worst = worst_prim(0) ** 2
print(worst - best)
