def postorder(i):
    global stack
    # lst[i] 가 존재할 때
    if lst[i]:
        # 후위순회 통해 후위계산식으로 만들기
        postorder(left[i])
        postorder(right[i])
        if type(lst[i]) == int:
            stack += [int(lst[i])]
        else:
            b = stack.pop()
            a = stack.pop()
            if lst[i] == '-':
                stack += [a - b]
            elif lst[i] == '+':
                stack += [a + b]
            elif lst[i] == '*':
                stack += [a * b]
            elif lst[i] == '/':
                stack += [int(a / b)]

T = 10
for tc in range(1, T+1):
    N = int(input())
    lst = [0] * (N+1)
    left = [0] * (N+1)
    right = [0] * (N+1)
    stack = []
    for _ in range(1, N+1):
        t = input().split()
        # 숫자일 경우
        if len(t) == 2:
            lst[int(t[0])] = int(t[1])
        # 3개인 경우가 존재할 수 있나..? 없다
        else:
            lst[int(t[0])] = t[1]
            left[int(t[0])] = int(t[2])
            right[int(t[0])] = int(t[3])
    postorder(1)
    print(f"#{tc} {int(stack[0])}")
