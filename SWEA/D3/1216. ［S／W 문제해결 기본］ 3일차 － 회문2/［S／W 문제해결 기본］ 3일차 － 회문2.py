def searching(param):
    for i in range(100):
        # 가로 탐색
        for j in range(100 - param + 1):
            if arr[i][j] == arr[i][j + param - 1]:
                # 반만큼만해가지고 앞 뒤로 하나씩 줄여오면서 확인
                for m in range(1, param // 2):
                    # 만약에 계속 줄여 오는 게 같지 않으면
                    if arr[i][j + m] != arr[i][j + param - 1 - m]:
                        break
                else:
                    return True
            # 다 끝마친 경우 결국 찾지 못했다는 거니깐 false
        # 세로 탐색
        for j in range(100 - param + 1):
            if arr[j][i] == arr[j + param - 1][i]:
                for m in range(1, param // 2):
                    if arr[j + m][i] != arr[j + param - 1 - m][i]:
                        break
                else:
                    return True
    return False

T = 10
for test_case in range(1, T+1):
    n = int(input())
    arr = []
    for i in range(100):
        arr.append(input())

    for cnt in range(100, -1, -1):
        if searching(cnt):
            print(f'#{n} {cnt}')
            break
