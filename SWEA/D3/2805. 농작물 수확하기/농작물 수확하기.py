T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = [[] for _ in range(N)]
    for i in range(N):
        t = input().strip()
        for j in range(len(t)):
            arr[i].append(int(t[j]))
    # start 는 중앙값이다
    start = int(N/2)
    # start 위치에서 양쪽 끝으로 간다.
    # 그러면서 한칸씩 올라갈 때는 -1만큼씩 빼는 것만큼 간다.
    cnt = 0
    for i in range(N):
        # 마름모 구현하듯이 한다.
        if i <= start:
            # 전체 수에서 start 수만큼 빼고 i 값만큼 더한 곳 까지 가면 바둑판처럼 되고
            for j in range(start - i, N - start + i):
                cnt += arr[i][j]
        else:
            # i가 start보다 커지니까 전체 수에서 i만큼 빼고 start 만큼 더하면 바둑판처럼 된다.
            for j in range(i - start, N - i + start):
                cnt += arr[i][j]
    print(f"#{tc} {cnt}")
