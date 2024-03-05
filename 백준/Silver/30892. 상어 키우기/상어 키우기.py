N, K, T = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
stack = []
cnt = 0
for i in range(len(arr)):
    # 만약에 현재 크기보다 크거나 같은게 나오면 이전까지 집어 넣었던 것을 먹는다.
    # 숫자가 더 크면 이전껄 잡아 먹고 하는게 나은지 아닌지 확인
    shark = arr[i]
    if shark >= T:
        # 스택이 비어있지 않다면
        # 여기서 while 문 써서 잡아먹어야할 듯 지금까지 있는 애들을 먹어서
        # 현재 애보다 커지면 잡아먹는 거 멈추고 현재 애를 저장하고 넘어가야한다.
        # 지금까지 넣은 애들은 어차피 다 작은 애들
        # T를 집어 먹고 현재 애보다 커지면 멈추고 stack에 추가
        while T <= shark and len(stack) != 0:
            if cnt == K:
                break
            prey = stack.pop()
            T += prey
            cnt += 1
        if shark >= T:
            break
        else:
            stack.append(shark)
        # 스택이 비어있으면 어차피 얘를 저장하나 마나 상관이 없다.
        # 얘 이후는 얘보다 크고 얘도 못 먹으면 성장불가

    # 현재 크기보다 작으면 바로 잡아먹을 수 있으니 저장하고 넘어간다.
    else:
        stack.append(shark)
    # print("i = ", i, "arr[i] =", arr[i], "stack = ", stack, "cnt = ", cnt, "T = ", T)
    if cnt == K:
        break
# 만약 다 하고 나서도 cnt 가 다 안된다면 stack이 빌 때까지나 cnt가 다 찰 때까지
# 마지막까지 온거니깐 난 stack에 있는 다른 애들보다 크다는 뜻
while cnt < K and len(stack) != 0:
    prey = stack.pop()
    # T가 꺼낸 것 보다 더 크다면
    T += prey
    cnt += 1
print(T)
