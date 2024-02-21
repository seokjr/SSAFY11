N = int(input())
liters = list(map(int, input().split()))
cities = list(map(int, input().split()))

ans = 0
for i in range(N-1):
    arr = []
    # 최소값일 때는 다 사고
    if cities[i] <= min(cities[i+1:]):
        ans += sum(liters[i:]) * cities[i]
        # 멈춘다.
        break
    # 최소값이 아닐 때는 최소값인 도시까지의 기름량 만큼만
    else:
        minval = min(cities[i+1:])
        for m in range(i, N-1):
            # 최솟값인 도시의 인덱스를 찾아 놓는다.
            if cities[m] == minval:
                t = m
                break
        # 현재부터 최소값인 도시까지의 기름량 만큼을 산다.
        for k in range(i, m+1):
            ans += liters[k] * cities[i]
        # ans += liters[i:m+1] * cities[i]
print(ans)
