T = int(input())
for tc in range(1, T+1):
    N = list(input())
    start = ['0'] * len(N)
    answer = 0
    for i in range(len(N)):
        # 만약 글자가 다르다면
        if N[i] != start[i]:
            # 그 자리부터 뒷 모든 자리를 다 바꿔준다.
            answer += 1
            for j in range(i, len(start)):
                # 만약 자리가 1이면 0으로 0이면 1로
                if start[j] == '1':
                    start[j] = '0'
                else:
                    start[j] = '1'

    print(f"#{tc} {answer}")
