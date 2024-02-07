T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    arr = [[] for _ in range(N)]
    for i in range(N):
        arr[i] = list(map(int, input().split()))
    answer = 0
    # 끝 점은 N-M+1 까지 가야 마지막까지 찾을 수 있다.
    answer_list = []
    for r in range(N-M+1):
        for c in range(N-M+1):
            answer = 0
            for i in range(M):
                for j in range(M):
                    answer += arr[r+i][c+j]
            answer_list.append(answer)

    print(f'#{test_case} {max(answer_list)}')