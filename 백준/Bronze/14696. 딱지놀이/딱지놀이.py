N = int(input())
for _ in range(N):
    # 4별 3동그라미 2네모 1세모
    A = list(map(int, input().split()))
    A = A[1:]
    B = list(map(int, input().split()))
    B = B[1:]
    A_4 = A.count(4)
    B_4 = B.count(4)
    A_3 = A.count(3)
    B_3 = B.count(3)
    A_2 = A.count(2)
    B_2 = B.count(2)
    A_1 = A.count(1)
    B_1 = B.count(1)
    if A_4 > B_4:
        print('A')
    elif B_4 > A_4:
        print('B')
    else:
        if A_3 > B_3:
            print('A')
        elif B_3 > A_3:
            print('B')
        else:
            if A_2 > B_2:
                print('A')
            elif B_2 > A_2:
                print('B')
            else:
                if A_1 > B_1:
                    print('A')
                elif B_1 > A_1:
                    print('B')
                else:
                    print('D')
