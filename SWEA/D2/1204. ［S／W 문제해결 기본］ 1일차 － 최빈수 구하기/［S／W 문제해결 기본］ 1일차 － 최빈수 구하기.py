T = int(input())

for test_case in range(1, T + 1):
    _ = int(input())
    student_list = list(map(int, input().split()))
    freq = [0] * 101
    maximum = 0
    for student in student_list:
        freq[student] += 1
        if freq[student] >= freq[maximum]:
            maximum = student
	        
    print(f'#{test_case} {maximum}')
