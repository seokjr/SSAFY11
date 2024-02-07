from itertools import combinations

arr = []
for _ in range(9):
    arr.append(int(input()))

total = 100
t = list(combinations(arr, 7))
for i in t:
    if sum(i) == total:
        answer = i
        break
for i in sorted(answer):
    print(i)
