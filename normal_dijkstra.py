import sys

input = sys.stdin.readline
INF = int(1e9)
# 노드와간선
n, m = map(int, input().split())
# 시작노드
start = int(input())
# 각 노드에 연결되어있는 노드에 대한 정보담기
graph = [[] for i in range(n + 1)]
# 방문한적이 있는지 체크리스트
visited = [False] * (n + 1)
# 최단거리 테이블 무한대로 초기화
distance = [INF] * (n + 1)

# 간성정보 입력
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def get_smallest_node():
    min_value = INF
    index = 0
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index


def dijkstra(start):
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1]

    for i in range(n - 1):
        now = get_smallest_node()
        visited[now] = True

        for j in graph[now]:
            cost = distance[now] + j[1]
            if cost < distance[j[0]]:
                distance[j[0]] = cost


dijkstra(start)

# 모든경로 최단거리 출력
for i in range(1, n + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
