croa = list(input())
# 거꾸로 가져오면서
answer = 0
i = len(croa)-1
while i >= 0:
    if croa[i] == "=":
        if croa[i - 1] == "c":
            answer += 1
            i -= 2
        elif croa[i - 1] == "s":
            answer += 1
            i -= 2
        # z일 때
        elif croa[i - 1] == "z":
            if croa[i - 2] == "d":
                answer += 1
                i -= 3
            else:
                answer += 1
                i -= 2
    # -일때
    elif croa[i] == "-":
        if croa[i - 1] == "c":
            answer += 1
            i -= 2
        elif croa[i - 1] == "d":
            answer += 1
            i -= 2
    # j일때
    elif croa[i] == "j":
        if croa[i - 1] == "l":
            answer += 1
            i -= 2
        elif croa[i - 1] == "n":
            answer += 1
            i -= 2
        else:
            answer += 1
            i -= 1
    else:
        answer += 1
        i -= 1
print(answer)
