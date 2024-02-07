T = int(input())
for test_case in range(1, T+1):
    String = input()
    stack = []
    cnt = 0
    for i in range(len(String)):
        # (를 만날 때와
        if String[i] == "(":
            stack.append(String[i])
        # )를 만날 때가 경우가 다르다.
        elif String[i] == ")":
            # 바로 전 것과 함께 레이저일 경우
            if String[i-1] == "(":
                # stack에서 빼버리고
                stack.pop()
                # 남은 (의 개수만큼 더해준다. 긴 막대들은 그대로 계속 잘릴 거니까.
                cnt += len(stack)
            # 한 쇠의 끝인 경우
            else:
                # 그 쇠는 끝났으니까 빼주고 잘렸으니 cnt를 하나 올린다.
                stack.pop()
                cnt += 1
    print(f"#{test_case} {cnt}")