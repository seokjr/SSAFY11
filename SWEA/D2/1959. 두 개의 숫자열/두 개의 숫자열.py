T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    a, b = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    if len(A) > len(B):
        A, B = B, A
    arr = []

    for k in range(len(B)-len(A)+1) : 
        sum = 0
        for r in range(len(A)) : 
            sum += A[r] * B[r+k]
        arr.append(sum) 
    print(f'#{test_case} {max(arr)}')
