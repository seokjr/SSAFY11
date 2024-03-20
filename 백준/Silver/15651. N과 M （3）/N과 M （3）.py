def perm(idx):
    global N
    global result
    global visited
    global num
    if idx >= M:
        print(" ".join(map(str, result)))
        return
    for i in range(N):
        visited[i] = True
        result[idx] = num[i]
        perm(idx + 1)
        visited[i] = False


N, M = map(int, input().split())
num = [i for i in range(1, N+1)]
visited = [False] * N
result = [0] * M
perm(0)
