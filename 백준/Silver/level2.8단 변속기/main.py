import sys
input = sys.stdin.readline
arr = list(map(int, input().rstrip().split()))
max_dp = [1] * 8
min_dp = [8] * 8
for i in range(1, 8):
    for j in range(i):
        if arr[i] > arr[j]:
            max_dp[i] = max(max_dp[i], max_dp[j] + 1)
        if arr[i] < arr[j]:
            min_dp[i] = min(min_dp[i], min_dp[j] - 1)
if max(max_dp) == 8:
    print("ascending")
elif min(min_dp) == 1:
    print("descending")
else:
    print("mixed")
