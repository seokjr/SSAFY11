T = 10
for test_case in range(1, T + 1):
    N = int(input())
    arr = [[] for _ in range(100)]
    answer_list = []
    for i in range(100):
        arr[i] = list(map(int, input().split()))
    # 행의 합
    for i in range(100):
        answer_list.append(sum(arr[i]))
    new_arr = [[0 for _ in range(100)] for _ in range(100)]
    for i in range(100):
        for j in range(100):
            new_arr[i][j] = arr[100 - j - 1][i]
    for i in range(100):
        answer_list.append(sum(new_arr[i]))
    answer = 0
    for i in range(100):
        for j in range(100):
            if i == j:
                answer += arr[i][j]
    answer_list.append(answer)
    print(f'#{N} {max(answer_list)}')