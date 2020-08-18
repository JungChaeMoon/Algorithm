from collections import deque

nodes = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]
visited = [False] * 9


def bfs(start):
    queue = deque([])
    visited[start] = True
    queue.append(start)
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in nodes[v]:
            if not visited[i]:
                queue.append(i)
                visited[i]= True


if __name__=="__main__":
    bfs(1)

