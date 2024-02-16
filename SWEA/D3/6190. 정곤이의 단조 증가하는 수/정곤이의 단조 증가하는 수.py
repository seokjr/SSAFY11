T = int(input())
for tc in range(1, T+1):
    N = int(input())
    arr = list(map(int, input().split()))
    answer = -1
    for i in range(len(arr)):
        for j in range(i+1, len(arr)):
            flag = False
            t = str(arr[i] * arr[j])
            first = int(t[0])
            for k in range(1, len(t)):
                second = int(t[k])
                if first > second:
                    flag = True
                    break
                first = int(t[k])
            if not flag:
                if answer <= int(t):
                    answer = int(t)
    print(f"#{tc} {answer}")
