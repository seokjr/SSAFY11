N = int(input())
Max_length = 166666667
answer = 1
max_t = 1
min_t = 1

for i in range(1, Max_length):
    if N == 1:
        break
    # (i+1)로 할 수 ㅇㅆ는 방법 생각.
    min_t = max_t + 1
    max_t = 6 * i + min_t - 1
    answer += 1
    if min_t <= N <= max_t:
        break
print(answer)