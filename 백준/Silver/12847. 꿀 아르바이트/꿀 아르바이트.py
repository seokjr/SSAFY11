N, K = map(int, input().split())
arr = list(map(int, input().split()))

total = ans = sum(arr[0:K])
if K != 0:
    for i in range(N-K):
        total -= arr[i]
        total += arr[i+K]
        ans = max(total, ans)
else:
    ans = 0
print(ans)