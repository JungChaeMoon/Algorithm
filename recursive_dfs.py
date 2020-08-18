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


def dfs(v):
    visited[v] = True
    print(v, end=' ')
    for i in nodes[v]:
        if not visited[i]:
            dfs(i)


if __name__=="__main__":
    dfs(1)

