T = 10
for tc in range(1, T+1) :
    N = int(input())
    origin = list(map(int, input().split()))
    orderN = int(input())
    order_list = list(input().split())

    type = ''
    position = -1
    howmany = -1
    for i in range(len(order_list)) :
        if order_list[i] in ['I', 'D', 'A'] :
            type = order_list[i]
            position = -1
            howmany = -1
        else :
            if type == 'I' : # 삽입할 때
                # position이 정의가 안됐으면 정의해주고 넘어가기
                if position == -1 :
                    position = int(order_list[i])
                    continue
                else :
                    # position은 정의 됐는데 얼만큼할지 정의 안됐으면 정의하고 넘어가기
                    if howmany == -1 :
                        howmany = int(order_list[i])
                        continue
					# 그 외는 모두 정의 됐으니까 다 삽입하기
                    origin.insert(position, int(order_list[i]))
                    position += 1
            elif type == 'D' : # 삭제
                # 여기도 유사하다. 정의 됐는지 안됐는지 확인
                if position == -1 :
                    position = int(order_list[i])
                    continue
                else :
                    if howmany == -1 :
                        howmany = int(order_list[i])
                        for j in range(howmany) :
                            del origin[position]
            elif type == 'A' : # 추가
                if howmany == -1 :
                    howmany = int(order_list[i])
                else :
                    origin.append(int(order_list[i]))

    print(f'#{tc}', end=' ')
    print(*origin[:10])