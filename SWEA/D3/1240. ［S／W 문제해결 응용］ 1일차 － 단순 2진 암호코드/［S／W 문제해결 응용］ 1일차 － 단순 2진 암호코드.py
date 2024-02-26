T = int(input())
for tc in range(1, T+1):
    H, W = map(int, input().split())
    arr = []
    for i in range(H):
        arr.append(list(input()))
     
    row = 0
    for i in range(H):
        # 만약 1이 들어가 있는 행이 나온다면 멈추고 그 행을 기억
        if arr[i].count('1') != 0:
            row = i
            break
     
    tar = arr[row]
     
    odd_num = 0
    even_num = 0
    start = 0
    for i in range(len(tar)-1, -1, -1):
        # 뒤부터 보면서 처음 1이 나오면 거기부터 암호이다.
        if tar[i] == '1':
            start = i
            break
     
    cnt = 0
    # 7씩 건너뛴다.
    for i in range(start, start-(8*7), -7):
        temp = ''
        num = 0
        for j in range(6, -1, -1):
            temp += tar[i-j]
        if temp == '0001101':
            num = 0
        elif temp == '0011001':
            num = 1
        elif temp == '0010011':
            num = 2
        elif temp == '0111101':
            num = 3
        elif temp == '0100011':
            num = 4
        elif temp == '0110001':
            num = 5
        elif temp == '0101111':
            num = 6
        elif temp == '0111011':
            num = 7
        elif temp == '0110111':
            num = 8
        elif temp == '0001011':
            num = 9
        # 뒤부터 오는 건데 짝수면
        if cnt % 2 == 0:
            even_num += num
        else:
            odd_num += num
        cnt += 1
    
    answer = 0
    # 홀수들에 3곱하고 짝수를 더한 만큼의 나머지가 0이면 암호이다.
    if ((odd_num * 3) + even_num) % 10 == 0:
        answer = odd_num + even_num
    else:
        answer = 0
    print(f'#{tc} {answer}')