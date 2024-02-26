w, h = map(int, input().split())
x, y = map(int, input().split())
t = int(input())

r = (x + t) // w
if r < 1:
    ar = x + t
# 나눈 값이 홀수면 w에서 나머지 만큼 뺀다
elif r % 2 == 1:
    ar = w - ((x+t) % w)
# 나눈 값이 짝수면 0에서 나머지 만큼 더한다.
elif r % 2 == 0:
    ar = 0 + ((x + t) % w)
c = (y + t) // h
if c < 1:
    ac = y + t
# 나눈 값이 홀수면 h에서 나머지 만큼 뺀다
elif c % 2 == 1:
    ac = h - ((y+t) % h)
# 나눈 값이 짝수면 0에서 나머지 만큼 더한다.
elif c % 2 == 0:
    ac = 0 + ((y + t) % h)
print(ar, ac)