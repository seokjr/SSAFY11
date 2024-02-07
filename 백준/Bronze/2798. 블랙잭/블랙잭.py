N, M = map(int, input().split())
arr = list(map(int,input().split()))

max_answer = 0
arr.sort()
dp = [0 for i in range(N)]
for i in range(N):
    for j in range(i+1, N):
        for t in range(j+1, N):
            if arr[i] + arr[j] + arr[t] > M:
                continue
            else:
                max_answer = max(max_answer, arr[i] + arr[j] + arr[t])

print(max_answer)
