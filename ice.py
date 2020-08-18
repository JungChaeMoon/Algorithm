import sys

graph = []
x_stack = []
y_stack = []

dir_x = [-1, 1, 0, 0]
dir_y = [0, 0, 1, -1]


def solution(x, y):
    graph[x][y] = 1
    x_stack.append(x)
    y_stack.append(y)
    while x_stack and y_stack:
        x = x_stack.pop()
        y = y_stack.pop()
        graph[x][y] = 1
        for i in range(4):
            nx = x + dir_x[i]
            ny = y + dir_y[i]
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] == 0:
                    x_stack.append(nx)
                    y_stack.append(ny)


if __name__=="__main__":
    count = 0
    N, M = map(int, sys.stdin.readline().split())
    for _ in range(N):
        graph.append(list(map(int, input())))

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 0:
                solution(i, j)
                count += 1

    print(count)
