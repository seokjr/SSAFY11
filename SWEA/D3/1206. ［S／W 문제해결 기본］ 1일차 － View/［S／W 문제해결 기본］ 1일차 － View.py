T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # ///////////////////////////////////////////////////////////////////////////////////
    N = int(input())
    APT = list(map(int, input().split()))
    #       #처음 2제외  97까지
    answer = 0
    for i in range(2, N-2):
        cur = APT[i]
        minus1 = APT[i - 1]
        minus2 = APT[i - 2]
        plus1 = APT[i + 1]
        plus2 = APT[i + 2]
        # 만약 하나라도 그거를 넘게 되면 다음으로 넘어가도 된다.
        # 둘 중에 하나라도 안 넘으면 ok이고 더 큰 값에서 현재 값을 빼서 하면 됨
        temp_max = max(minus1, minus2, plus1, plus2)
        if cur > temp_max:
            answer += cur - temp_max

    print(f'#{test_case} {answer}')