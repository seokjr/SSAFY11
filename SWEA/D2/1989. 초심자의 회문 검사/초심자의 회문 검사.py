T = int(input())
for test_case in range(1, T+1):
    target = input().strip()
    index = int(len(target)/2)
    front = target[0:index]
    if len(target) % 2 == 1:
        tail = target[index + 1:]
        tail = tail[::-1]
    else:
        front = target[0:index]
        tail = target[index:]
        tail = tail[::-1]
    if front == tail:
        print(f'#{test_case} {1}')
    else:
        print(f'#{test_case} {0}')