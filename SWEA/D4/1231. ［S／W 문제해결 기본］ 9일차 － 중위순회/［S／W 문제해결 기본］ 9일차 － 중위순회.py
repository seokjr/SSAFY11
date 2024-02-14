def inorder(i):
    if i <= N:
        # 중위순회
        inorder(i*2)
        print(lst[i], end="")
        inorder(i*2 + 1)
 
T = 10
for tc in range(1, T+1):
    N = int(input())
    lst = [0 for _ in range(N+1)]
    for _ in range(1, N+1):
        t = input().split()
        # 입력을 나눠서 본인이 해당하는 번호에 넣어준다.
        lst[int(t[0])] = t[1]
    print(f"#{tc}", end= " ")
    inorder(1)
    print()