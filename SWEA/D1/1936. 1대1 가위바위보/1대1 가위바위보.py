a, b = map(int, input().split())
# 1 가위 2 바위 3 보
answer = ''
if a == 1:
    if b == 3:
        answer = 'A'
    if b == 2:
        answer = 'B'
if a == 2:
    if b == 1:
        answer = 'A'
    if b == 3:
        answer = 'B'
if a == 3:
    if b == 2:
        answer = 'A'
    if b == 1:
        answer = 'B'
print(answer)