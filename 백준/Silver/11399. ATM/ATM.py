N = int(input())
arr = list(map(int, input().split()))
arr.sort()
answer = 0
temp = 0
for i in arr:
    temp += i
    answer += temp

print(answer)