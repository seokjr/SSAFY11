t = int(input())
for tc in range(1, t+1):
    N, K = map(int, input().rstrip().split())
    answer = 0
    arr = input().rstrip()
    lst = []
    for i in range(N):
        lst.append(arr[i])
    answer_lst = []
    for i in range(N):
        for m in range(0, N, N//4):
            temp = "".join(lst[m:(m+N//4)])
            int_temp = int(temp, 16)
            answer_lst.append(int_temp)
        lst.insert(0, lst[-1])
        del lst[-1]

    answer_set = set(answer_lst)
    a_s = sorted(answer_set, reverse=True)
    answer = a_s[K-1]
    print(f"#{tc} {answer}")