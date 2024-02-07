N = int(input())
arr = []
for _ in range(N):
    x, y = map(int, input().split())
    arr.append((x, y))
tmap = [[0 for j in range(100)] for i in range(100)]

cnt = 0
for a in arr:
    x1, y1 = a[0], a[1]
    for m in range(x1, x1+10):
        for b in range(y1, y1+10):
            tmap[m][b] = 1

for i in range(100):
    for j in range(100):
        if tmap[i][j] == 1:
            cnt += 1

print(cnt)