import sys
input = sys.stdin.readline


def dfs(x, y):
    global arr
    global n
    global cnt
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    if arr[x][y] == 1:
        arr[x][y] = 0
        cnt += 1
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)
        return True
    return False


n = int(input())
arr = []
answer = []
result = 0
for i in range(n):
    arr.append(list(map(int, input().rstrip())))
for r in range(n):
    for c in range(n):
        cnt = 0
        if dfs(r, c):
            result += 1
            answer.append(cnt)
answer.sort()
print(result)
for i in answer:
    print(i)
