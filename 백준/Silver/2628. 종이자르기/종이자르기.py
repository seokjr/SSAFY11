row_N, col_N = map(int, input().split())
row = [0, col_N]
column = [0, row_N]
T = int(input())
for _ in range(T):
    cut_dir, row_number = map(int, input().split())
    if cut_dir == 0:  # 가로로 자르는 게 나왔을 때
        row.append(row_number)
    elif cut_dir == 1:  # 세로로 자르는 게 나왔을 때
        column.append(row_number)
row.sort()
column.sort()
answer_list = []
before_row = row[0]
for i in range(1, len(row)):  # -1 해야 하고
    before_column = column[0]
    for j in range(1, len(column)):  # + 1 해야 한다.
        length = abs(before_row-row[i]) * abs(before_column-column[j])
        answer_list.append(length)
        before_column = column[j]
    before_row = row[i]

# print('행 : ', row)
# print('열 : ', column)
# print('정답 목록 : ', answer_list)
# print('정답 : ', max(answer_list))
print(max(answer_list))