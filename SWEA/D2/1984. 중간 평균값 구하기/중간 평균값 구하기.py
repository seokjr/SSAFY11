T = int(input())
for test_case in range(1, T + 1):
    answer = 0
    arr = list(map(int, input().split()))
    arr.sort()
    new_arr = arr[1:-1]
    answer = round(sum(new_arr)/len(new_arr))
    print("#{0} {1}".format(test_case, answer))
