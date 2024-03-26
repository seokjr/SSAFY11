T = int(input())
for tc in range(1, T+1):
    oneDay, oneMonth, threeMonth, oneYear = map(int, input().split())
    plan = list(map(int, input().split()))
    plan.insert(0, 0)
    dp = [0] * 13
    for i in range(1, 13):
        # dp를 사용해서 한 달씩을 계산하고
        dp[i] = min(dp[i-1] + (oneDay * plan[i]), dp[i-1] + oneMonth)
        # 3달치가 가능할 땐 3달치의 것도 현재의 값과 비교하여 생각한다.
        if i >= 3:
            dp[i] = min(dp[i], dp[i-3] + threeMonth)

    answer = min(dp[12], oneYear)
    print(f'#{tc} {answer}')