N = int(input())
arr = []
for i in range(1, N+1):
    t = str(i)
    temp = ''
    for m in range(len(t)):
        if '3' in t[m]:
            temp += '-'
        if '6' in t[m]:
            temp += '-'
        if '9' in t[m]:
            temp += '-'
    if temp != '':
        arr.append(temp)
    else:
        arr.append(i)

print(*arr)
