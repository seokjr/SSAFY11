N, M, L = map(int, input().split())

member_list = [0 for i in range(N)]
member_list.insert(0, -1)
start = 1
answer = -1
while max(member_list) < M:
    member_list[start] += 1
    if member_list[start] % 2 == 1:
        start += L
        if start > N:
            start -= N
    else:
        start -= L
        if start <= 0:
            start += N
    answer += 1

print(answer)
