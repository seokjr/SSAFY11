n = int(input())
arr = []
for _ in range(n):
    arr.append(int(input()))
stack = []
answer_list = []
start = 1
cnt = 0
while len(arr) != 0:
    # push를 계속 하다가
    # 더하는 숫자가 n보다는 작거나 같아야한다.
    # 비어있고 최대값보다 작으면 추가
    if start <= n:
        stack.append(start)
        answer_list.append("+")
    # 가장 위의 있는 수가 arr의 처음에 써 있는 수를 만난다면
    if len(arr) != 0 and len(stack) != 0:
        while stack[-1] == arr[0]:
            stack.pop()
            del arr[0]
            answer_list.append('-')
            if len(stack) == 0:
                break
    # if stack[-1] == arr[0]:
    #     # stack에서도 없애고
    #     stack.pop()
    #     # arr에서도 없앤다.
    #     del arr[0]
    #     answer_list.append('-')
    # print('stack = ', stack)
    # print('arr = ', arr)
    # print('answer_list = ', answer_list)
    # print('-' * 30)

    start += 1
    cnt += 1
    if cnt > n*2:
        break
if len(arr) != 0:
    print('NO')
else:
    for i in range(len(answer_list)):
        print(answer_list[i])