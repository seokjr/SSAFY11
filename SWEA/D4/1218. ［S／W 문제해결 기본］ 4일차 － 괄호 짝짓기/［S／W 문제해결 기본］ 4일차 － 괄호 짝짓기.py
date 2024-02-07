T = 10
for test_case in range(1, T+1):
    N = int(input())
    string = input()
    stack = []
    # 여는 괄호
    left = ['(', '{', '[', '<']
    # 닫는 괄호
    right = [')', '}', ']', '>']
    for i in range(len(string)):
        # 여는 괄호면 그냥 추가
        if string[i] in left:
            stack.append(string[i])
        if string[i] in right:
            # 가장 상위의 괄호 값과 쌍이라면
            if right.index(string[i]) == left.index(stack[-1]):
                # 상위의 원소 제거하기
                stack.pop()
            else:
                break

    answer = 0
    if len(stack) == 0:
        answer = 1
    print(f"#{test_case} {answer}")