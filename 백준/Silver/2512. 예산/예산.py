N = int(input())
arr = list(map(int, input().split()))
maximum = int(input())
start, end = 1, max(arr)
arr.sort()
while start <= end:
    mid = (start + end) // 2
    my_line = 0  # 가져갈 부분
    # 예산을 보면서
    for i in arr:
        if i >= mid:
            # 예산이 mid 보다 같거나 크면 mid 까지만 더하고
            my_line += mid
        else:
            my_line += i
    # 자른 부분 과하다면 왼쪽으로 가서 잘라야 한다. 왜냐면 최대 예산이니깐
    if my_line > maximum:
        end = mid - 1
    # 만약 자른 부분이 모자라면 오른쪽으로 가고 키워야 예산안을 높인다.
    else:
        start = mid + 1
print(end)
