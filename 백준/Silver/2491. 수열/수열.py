T = int(input())
arr = list(map(int, input().split()))
# 커지는 수열 순서 찾고
upper_list = []
before_up = arr[0]
cnt = 1
for i in range(1, len(arr)):
    if before_up <= arr[i]:
        cnt += 1
    else:
        upper_list.append(cnt)
        cnt = 1
    before_up = arr[i]
upper_list.append(cnt)
down_list = []
before_down = arr[0]
cnt = 1
for i in range(1, len(arr)):
    if before_down >= arr[i]:
        cnt += 1
    else:
        down_list.append(cnt)
        cnt = 1
    before_down = arr[i]
down_list.append(cnt)
answer = max(max(upper_list), max(down_list))
print(answer)