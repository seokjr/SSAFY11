T = 10
for tc in range(1, T+1):
    N = int(input())
    origin = list(map(int, input().split()))
    orderN = int(input())
    # I 기준으로 명령어를 나눈다.
    order_list = list(map(str, input().split("I")))
    # print(order_list)
    # 0번째는 빈칸으로 되기 때문에 1부터 시작한다.
    for i in range(1, len(order_list)):
        t = order_list[i].split()
        position = int(t[0])
        howmany = int(t[1])
        for j in range(2, 2+howmany):
            origin.insert(position, int(t[j]))
            position += 1
    print(f"#{tc}", end= " ")
    for m in range(10):
        print(origin[m], end=" ")
    print()