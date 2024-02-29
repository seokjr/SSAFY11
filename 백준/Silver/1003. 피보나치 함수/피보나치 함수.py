def fibo_zero(num):
    if num == 0:
        dp_zero[num] = 1
    elif num == 1:
        dp_zero[num] = 0
    elif dp_zero[num] != 0:
        return dp_zero[num]
    else:
        dp_zero[num] = fibo_zero(num-1) + fibo_zero(num-2)
    return dp_zero[num]


def fibo_one(num):
    if num == 0:
        dp_one[num] = 0
    elif num == 1:
        dp_one[num] = 1
    elif dp_one[num] != 0:
        return dp_one[num]
    else:
        dp_one[num] = fibo_one(num-1) + fibo_one(num-2)
    return dp_one[num]


T = int(input())
for i in range(T):
    N = int(input())
    dp_zero = [0] * (N+1)
    dp_one = [0] * (N+1)
    print(fibo_zero(N), fibo_one(N))

