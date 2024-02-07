import sys
N = int(sys.stdin.readline())
stack = []
def module_stack(direction, num:0):
    pass


for i in range(N):
    direction = sys.stdin.readline().split()
    if direction[0] == "push":
        stack.append(direction[1])
    elif direction[0] == "top":
        if len(stack) != 0:
            print(stack[-1])
        else:
            print(-1)
    elif direction[0] == "pop":
        if len(stack) != 0:
            print(stack.pop())
        else:
            print(-1)
    elif direction[0] == "size":
        print(len(stack))
    elif direction[0] == "empty":
        if len(stack) == 0:
            print(1)
        else:
            print(0)
