arr = [int(input()) for i in range(10)]
answer = [a%42 for a in arr]
print(len(set(answer)))