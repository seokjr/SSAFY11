T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    N_list = list(map(str, input().split()))
    M_list = list(map(str, input().split()))
    num = int(input())

    print(f'#{test_case}', end=" ")
    for i in range(num):
        target = int(input())
        n_pos = (target % len(N_list)) - 1
        m_pos = (target % len(M_list)) - 1
        answer = N_list[n_pos] + M_list[m_pos]
        print(answer, end=" ")
    print()
