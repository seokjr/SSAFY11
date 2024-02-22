N = int(input())
plus = []
zero_and_minus = []
ones = []
for _ in range(N):
  t = int(input())
  if t <= 0:
    zero_and_minus.append(t)
  elif t > 1:
    plus.append(t)
  else:
    ones.append(t)

# 1들은 그냥 더하는게 무조건 좋다.
cnt = 0
cnt += sum(ones)
# 음수들은 무조건 곱한다. 0이랑
zero_and_minus.sort()
plus.sort()
plus.reverse()

if len(zero_and_minus) % 2 == 0:
  for i in range(0, len(zero_and_minus), 2):
    cnt += zero_and_minus[i] * zero_and_minus[i + 1]
else:
  for i in range(0, len(zero_and_minus) - 1, 2):
    cnt += zero_and_minus[i] * zero_and_minus[i + 1]
  cnt += zero_and_minus[-1]

if len(plus) % 2 == 0:
  for i in range(0, len(plus), 2):
    cnt += plus[i] * plus[i + 1]
else:
  for i in range(0, len(plus) - 1, 2):
    cnt += plus[i] * plus[i + 1]
  cnt += plus[-1]
print(cnt)
