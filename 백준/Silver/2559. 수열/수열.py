N, K = map(int, input().split())
arr = list(map(int, input().split()))
dp = [0] * (N - K + 1)
answer_list = []
before_i = arr[0]
for i in range(len(arr)-K+1):
    if i == 0:
        dp[i] = sum(arr[i:i+K])
    else:
        dp[i] = dp[i-1] - arr[i-1] + arr[i+K-1]
print(max(dp))