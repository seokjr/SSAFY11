# 가로를 쭉 돌면서 검사
def checking_row(row):
    cnt = 0
    for m in range(9):
        cnt += arr[row][m]
    # 한 줄의 합이 45가 아니라면 중복되는 게 있으니깐 안되는 거
    if cnt != 45:
        temp = 0
    else:
        temp = 1
    return temp


# 세로를 쭉 돌면서 검사
def checking_column(column):
    cnt = 0
    for m in range(9):
        cnt += arr[m][column]
    if cnt != 45:
        temp = 0
    else:
        temp = 1
    return temp


# 3 * 3을 돌면서 검사
def checking3by3(row, column):
    cnt = 0
    # 3으로 나눠서 어디부터 탐색할지 정해놓는다.
    x = row // 3
    y = column // 3
    for m in range(3 * x, 3 * (x+1)):
        for k in range(3 * y, 3 * (y+1)):
            cnt += arr[m][k]
    if cnt != 45:
        temp = 0
    else:
        temp = 1
    return temp


T = int(input())
for tc in range(1, T+1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    answer = 1
    for i in range(9):
        for j in range(9):
            # 만약에 어디 한 군데라도 아닌 곳이 나오면 바로 멈춘다. 어차피 안되니까
            answer = checking_row(i)
            if answer != 1:
                break
            answer = checking_column(j)
            if answer != 1:
                break
            answer = checking3by3(i, j)
            if answer != 1:
                break
        if answer != 1:
            break
    print(f"#{tc} {answer}")
