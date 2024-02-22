from itertools import combinations
N, S = map(int, input().split())
arr = list(map(int, input().split()))
cnt = 0
for i in range(1, N+1):
    c_arr = list(combinations(arr, i))
    for j in range(len(c_arr)):
        a = sum(c_arr[j])
        if a == S:
            cnt += 1
print(cnt)