N, M = map(int, input().split())
trees = list(map(int, input().split()))
left, right = 0, max(trees)
trees.sort()

while left <= right:
    mid = (left + right) // 2
    my_tree = 0  # 가져갈 부분
    # 나무를 보면서
    for i in trees:
        # mid 까지는 자른게 0일테니 넘기고
        if i > mid:
            # 나머지는 더한다.
            my_tree += i - mid
    # 자른 부분이 딱 맞으면 멈춤
    if my_tree >= M:
        left = mid + 1
    # 만약 자른 부분이 모자라면 왼쪽으로 가고
    else:
        right = mid - 1
    # 자른 부분 과하다면 오른쪽으로 가서 자른다.
print(right)