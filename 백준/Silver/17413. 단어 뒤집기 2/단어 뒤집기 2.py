N = input()
stack = []
flag = False
for i in range(len(N)):
    if N[i] == '<':
        flag = True
        while len(stack) > 0:
            print(stack.pop(), end='')
        print(N[i], end='')
        continue
    elif N[i] == '>':
        flag = False
        print(N[i], end='')
        continue
    if flag:
        print(N[i], end='')
    else:
        if N[i] == ' ':
            while len(stack) > 0:
                print(stack.pop(), end='')
            print(N[i], end='')
            continue
        stack.append(N[i])
while len(stack) > 0:
    print(stack.pop(), end='')
