N = int(input())
liters = list(map(int, input().split()))
cities = list(map(int, input().split()))

ans = 0
cur_price = cities[0]
for i in range(N - 1):
    # 이전 가격이 현재 가격보다 비싸면 갱신
    if cur_price > cities[i]:
        cur_price = cities[i]
    # 그렇지 않다면 그냥 현재 기름이랑 liters 만큼이랑 곱한다.
    ans += cur_price * liters[i]
print(ans)
