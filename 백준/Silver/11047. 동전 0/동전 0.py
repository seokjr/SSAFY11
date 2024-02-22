N, K = map(int, input().split())
arr = []
for _ in range(N):
  arr.append(int(input()))
arr.reverse()

coin = 0
for i in arr:
 if K // i >= 1:
   coin += K // i
   K = K % i
print(coin)
