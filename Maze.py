import sys
from collections import deque

graph = []
visited = []
dir_x = [-1, 1, 0, 0]
dir_y = [0, 0, 1, -1]

N, M = map(int, sys.stdin.readline().split())


def solution(x, y):
    count = 0
    queue = deque([])
    graph[x][y] = 1
    visited[x][y] = True
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dir_x[i]
            ny = y + dir_y[i]
            if 0 <= nx < N and 0 <= ny < M:
                if not visited[nx][ny] and graph[nx][ny] == 1:
                    queue.append((nx, ny))
                    graph[nx][ny] = graph[x][y] + 1
                    visited[nx][ny] = True


if __name__=="__main__":

    for _ in range(N):
        graph.append(list(map(int, input())))
        visited.append([False] * M)

    solution(0, 0)
    print(graph[N-1][M-1])

