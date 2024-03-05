string = input()
answer = ""
op = []
priority = {"+" : 1, "-" : 1, "*" : 2, "/" : 2, "(" : 0}
for i in range(len(string)):
    c = string[i]
    if c == '(':
        op.append(c)
    elif c == ')':
        while op[-1] != '(':
            answer += op.pop()
        op.pop()
    # 알파벳들
    elif c.isalpha():
        answer += c
    # 연산자들
    else:
        if len(op) == 0:
            op.append(c)
        else:
            while len(op) != 0 and priority[c] <= priority[op[-1]]:
                answer += op.pop()
            op.append(c)

while len(op) != 0:
    answer += op.pop()
print(answer)