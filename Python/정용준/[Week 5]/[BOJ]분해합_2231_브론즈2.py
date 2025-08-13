N = int(input())

for i in range(1, N + 1):
    # i의 분해합 계산
    total = i
    for digit in str(i):  # 각 자리 숫자 꺼내기
        total += int(digit)
    
    if total == N:  # 찾으면 출력하고 종료
        print(i)
        break
else:
    # for문이 끝날 때까지 못 찾으면
    print(0)