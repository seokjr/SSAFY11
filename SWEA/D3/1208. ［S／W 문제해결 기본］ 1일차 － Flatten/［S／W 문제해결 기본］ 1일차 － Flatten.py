T = 10
for test_case in range(1, T + 1):
    N = int(input())
    land = list(map(int, input().split()))
    cnt = 0
    # 만약 cnt 횟수가 N이랑 같아지면 그땐 끝내야 한다.
    # 다 수행하고 난 뒤의 최댓값과 최솟값의 차이.
    # 아니면 할 때마다 min 값이랑 max 값을 계속 구해서 max는 -1하고
    # min 은 +1 하고?
    for i in range(1000):
        max_index = land.index(max(land))
        min_index = land.index(min(land))
        land[max_index] -= 1
        land[min_index] += 1

        cnt += 1
        if cnt == N:
            break
        if abs(max(land)-min(land))  == 0:
            break

    answer = 0
    answer = abs(max(land)- min(land))
    print(f'#{test_case} {answer}')