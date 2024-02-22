N = int(input())
# 전체를 0으로 초기화하고
arr = [[0] * 1001 for _ in range(1001)]
cnt = [0] * (N+1)
for m in range(1, N+1):
    x, y, width, height = map(int, input().split())
    for i in range(y, y+height):
        for j in range(x, x+width):
            # 들어오는 순서대로 넘버를 붙여서 바꾼다
            arr[i][j] = m

# 행을 돌면서 숫자 count 만큼을 더해준다.
for m in range(1, N+1):
    for i in range(len(arr)):
        cnt[m] += arr[i].count(m)

for i in range(1, N+1):
    print(cnt[i])
