n = int(input())
arr = list(map(str, input()))
num_list = []
stack = []
for i in range(n):
    num_list.append(int(input()))

for a in range(len(arr)):
    if arr[a].isalpha():
        arr[a] = arr[a].replace(arr[a], str(num_list[ord(arr[a]) - 65]))

for i in range(len(arr)):
    if arr[i].isnumeric():
        stack.append(arr[i])
    else:
        # 덧셈
        if arr[i] == '+':
            b = float(stack.pop())
            a = float(stack.pop())
            stack.append(a + b)
        # 곱셈
        elif arr[i] == '*':
            b = float(stack.pop())
            a = float(stack.pop())
            stack.append(a * b)
        # 나눗셈
        elif arr[i] == '/':
            b = float(stack.pop())
            a = float(stack.pop())
            stack.append(a / b)
        # 뺄셈
        else:
            b = float(stack.pop())
            a = float(stack.pop())
            stack.append(a - b)
print("{0:0.2f}".format(stack[-1]))
