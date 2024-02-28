N, K = map(int, input().split())
lines = [int(input()) for _ in range(N)]
start, end = 0, max(lines)
lines.sort()
while start <= end:
    mid = (start + end) // 2
    if mid == 0:
        break
    my_line = 0  # 가져갈 부분
    # 라인들을 보면서
    for i in lines:

        if i >= mid:
            # 나머지는 더한다.
            my_line += i // mid
    # 자른 부분 과하다면 오른쪽으로 가서 자른다.
    if my_line >= K:
        start = mid + 1
    # 만약 자른 부분이 모자라면 왼쪽으로 가고
    else:
        end = mid - 1

print(end)
