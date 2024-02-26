N, K = map(int, input().split())
# 여자 0 남자 1
# 학년 별로도 남녀가 나눠져 있다.
girl = [0] * 7
boy = [0] * 7
for i in range(N):
    sex, grade = map(int, input().split())
    if sex == 0:
        girl[grade] += 1
    elif sex == 1:
        boy[grade] += 1
answer = 0
for i in range(1, 7):
    # 나눴을 때 나머지가 존재하면 한개만큼 더 써준다.
    if girl[i] % K != 0:
        answer += girl[i] // K
        answer += 1
    else:
        answer += girl[i] // K
    if boy[i] % K != 0:
        answer += boy[i] // K
        answer += 1
    else:
        answer += boy[i] // K

print(answer)
