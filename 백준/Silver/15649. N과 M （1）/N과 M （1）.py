from itertools import permutations
N, M = map(int, input().split())
arr = [i for i in range(1, N+1)]
t = list(permutations(arr, M))
for i in range(len(t)):
    m = list(t[i])
    for j in range(len(m)):
        print(m[j], end=" ")
    print('')