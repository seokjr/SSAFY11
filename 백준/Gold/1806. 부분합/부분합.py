import sys
N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
left = 0
right = 0
min_value = 1000001
total_sum = 0
while True:
    if total_sum >= S:
        min_value = min(min_value, right - left)
        total_sum -= arr[left]
        left += 1
    elif right == N:
        break
    else:
        total_sum += arr[right]
        right += 1

if min_value == 1000001:
    print(0)
else:
    print(min_value)