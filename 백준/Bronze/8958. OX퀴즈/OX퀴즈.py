N = int(input())
for i in range(N):
    problem = input()
    O_cnt = 0
    cnt = 0
    for j in range(len(problem)):
        t = problem[j]
        if t == 'O':
            O_cnt += 1
            cnt += O_cnt
        else:
            O_cnt = 0
    print(cnt)