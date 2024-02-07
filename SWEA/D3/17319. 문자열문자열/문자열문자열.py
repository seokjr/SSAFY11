#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    text = str(input())
    answer = ''
    if len(text) % 2 != 0:
            answer = "No"
    else:
        if text[:len(text)//2] == text[len(text)//2:]:
            answer = "Yes"
        else:
            answer = "No"
    
    print(f'#{test_case} {answer}')

