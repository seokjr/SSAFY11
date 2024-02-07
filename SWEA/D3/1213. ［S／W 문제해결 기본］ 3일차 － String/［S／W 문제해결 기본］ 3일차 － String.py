T = 10
for test_case in range(1, T+1):
    n = int(input())
    target = str(input())
    problem = input()
    answer = 0
    for i in range(len(problem)):
        first = problem[i]
        if first == target[0]:
            if problem[i:i+len(target)] == target:
                answer += 1
    print(f'#{n} {answer}')
