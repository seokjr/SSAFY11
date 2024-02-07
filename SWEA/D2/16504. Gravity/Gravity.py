T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
# N개의 0을 가지고 있는 리스트 result 생성
    result = [0]*N
# 반복하면서 자기자신보다 작은 값들일 때 갯수를 셈
    for i in range(N):
        cnt = 0
        for j in range(i +1, N):
            if arr[i] > arr[j]:
               cnt += 1
        result[i] = cnt
    answer = 0
# 최대값 찾기
    for num in range(len(result)):
        if result[num] > answer:
            answer = result[num]
    print(f'#{test_case} {answer}')
