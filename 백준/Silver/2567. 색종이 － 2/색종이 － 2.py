N = int(input())
origin = [[0 for j in range(101)] for i in range(101)]
for _ in range(N):
    x, y = map(int, input().split())
    for i in range(10):
        for j in range(10):
            origin[y+i][x+j] = 1

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
cnt = 0
for r in range(len(origin)):
    for c in range(len(origin[0])):
        if origin[r][c] == 1:
            for k in range(4):
                nr = r + dr[k]
                nc = c + dc[k]
                if origin[nr][nc] == 0 or 0 > nr or nr > 101 or 0 > nc or nc > 101:
                    cnt += 1
print(cnt)