T = 10
for test_case in range(1, T + 1):
    N = int(input())
    arr = [[] for _ in range(100)]
    for i in range(100):
        arr[i] = list(map(int, input().split()))

    y = arr[99].index(2)
    x = 99
    visited = [[0 for i in range(100)] for i in range(100)]

    while x != 0:
        visited[x][y] = 1
        if y - 1 >= 0 and arr[x][y - 1] and visited[x][y - 1] == 0:
            y -= 1
            continue
        elif y + 1 < 100 and arr[x][y + 1] and visited[x][y + 1] == 0:
            y += 1
            continue
        else:
            x -= 1

    answer = y
    print(f'#{N} {answer}')