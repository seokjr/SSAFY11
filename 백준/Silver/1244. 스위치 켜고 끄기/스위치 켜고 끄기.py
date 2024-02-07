def switchonoff(num):
    if light[num] == 0:
        light[num] = 1
    else:
        light[num] = 0
    return

n = int(input())  # 스위치 개수
answer = 0
light = list(map(int, input().split()))  # 전등의 처음 상태
student = int(input())  # 학생의 숫자
students = []
for _ in range(student):
    # 성별 숫자 그냥 바로 받고
    sex, pos = map(int, input().split())
    # 남자면 자기 받은 수의 배수 상태의 것들의 스위치 상태 바꿈
    first_pos = pos - 1
    if sex == 1:
        for i in range(len(light)):
            if i == first_pos:
                switchonoff(i)
                first_pos += pos
    # 여자면 자기 받은 수부터 양쪽으로 최대의 대칭까지 다 바꾼다. 대칭이 자기 다음부터 안되면 자기 자리만 바꿈
    else:
        switchonoff(first_pos)
        before_pos = first_pos - 1
        next_pos = first_pos + 1
        for i in range(n//2):
            # 인덱스 범위 안에 들어가야 함.
            if before_pos >= 0 and next_pos < n:
                # 만약 before 랑 next 랑 같은 경우
                if light[before_pos] == light[next_pos]:
                    switchonoff(before_pos)
                    switchonoff(next_pos)
                    before_pos -= 1
                    next_pos += 1
                else:
                    break
            else:
                break
light.insert(0, -1)
for i in range(1, n+1):
    print(light[i], end=" ")
    if (i % 20) == 0:
        print()