N, K = map(int, input().split())
arr = list(map(int, input().split()))

idx_arr = []
for i in range(len(arr)):
    if arr[i] == 1:
        idx_arr.append(i)

answer = 0


cnt = 0
min_cnt = 1e13
for idx in range(0, len(idx_arr) - K + 1):
    cnt = idx_arr[idx + K - 1] - idx_arr[idx] + 1
    min_cnt = min(cnt, min_cnt)

if len(idx_arr) < K:
    answer = -1
else:
    answer = min_cnt
print(answer)
