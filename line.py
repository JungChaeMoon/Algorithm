import sys

input = sys.stdin.readline

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
degree = [0] * (n+1)
stack = []
answer = ''


#Topological sorting
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    degree[b] += 1


for idx, val in enumerate(degree):
    if val == 0 and idx > 0:
        stack.append(idx)
        answer += '{} '.format(idx)


while stack:
    now = stack.pop()
    for node in graph[now]:
        degree[node] -= 1
        if degree[node] == 0:
            stack.append(node)
            answer += '{} '.format(node)

print(answer.rstrip())
