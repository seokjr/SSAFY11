def combination(idx):
    global N, K, cnt, check
    # base case
    if idx >= N:
        sum = 0
        for i in range(N):
            if check[i]:
                sum += arr[i]
        if sum == K:
            cnt += 1
        return

    # recursive
    check[idx] = True
    combination(idx+1)
    check[idx] = False
    combination(idx+1)


T = int(input())
for tc in range(1, T+1):
    N, K = map(int, input().split())
    arr = list(map(int, input().split()))
    cnt = 0
    check = [False] * N
    combination(0)
    print(f'#{tc} {cnt}')