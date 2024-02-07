arr = []
for _ in range(10):
    arr.append(int(input()))

answer_list = []
total_sum = 0
# 누적 합을 결과에 임시 저장
for i in range(len(arr)):
    total_sum += arr[i]
    answer_list.append(total_sum)

# 결과 중에서 100까지의 거리를 구할 것들을 만든다.
hundred_sum = []
for i in range(len(answer_list)):
    hundred_sum.append(abs(answer_list[i]-100))
# 100까지의 거리 것들 중에서 가장 작은 값인데 가장 작은 값이 같으면 더 큰거
min_value = 10000000000001

for i in range(10):
    if hundred_sum[i] <= min_value:
        min_value = hundred_sum[i]
        answer = answer_list[i]

print(answer)