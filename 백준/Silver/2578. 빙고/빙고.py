def row_checking():
    temp = 0
    for i in range(5):
        cnt = 0
        for j in range(5):
            if cor_lst[i][j] == 1:
                cnt += 1
        if cnt == 5:
            temp += 1
    return temp


def column_checking():
    temp = 0
    for i in range(5):
        cnt = 0
        for j in range(5):
            if cor_lst[j][i] == 1:
                cnt += 1
        if cnt == 5:
            temp += 1
    return temp


def dia_checking():
    temp = 0
    # 오->왼
    cnt = 0
    for i in range(5):
        if cor_lst[i][5 - i - 1] == 1:
            cnt += 1
    if cnt == 5:
        temp += 1
    # 왼->오
    cnt = 0
    for i in range(5):
        if cor_lst[i][i] == 1:
            cnt += 1
    if cnt == 5:
        temp += 1
    return temp


arr = []
for i in range(5):
    arr.append(list(map(int, input().split())))
mc_call = []
for _ in range(5):
    t = list(map(int, input().split()))
    for m in t:
        mc_call.append(m)

cor_lst = [[0 for j in range(5)] for i in range(5)]
cnt = 0
for call in range(len(mc_call)):
    s = mc_call[call]
    for i in range(5):
        for j in range(5):
            if s == arr[i][j]:
                cnt = 0
                cor_lst[i][j] = 1
                cnt += row_checking()
                cnt += column_checking()
                cnt += dia_checking()
                if cnt >= 3:
                    print(call+1)
                    exit()