import sys

initial_num = int(sys.stdin.readline())

current_num = initial_num 

count = 0

while True:
    count += 1
    
    # 1. 현재 숫자를 두 자리로 분리하여 리스트에 저장
    tens = current_num // 10  # 십의 자리
    ones = current_num % 10   # 일의 자리
    current_arr = [tens, ones]
    
    # 2. 각 자리의 숫자를 더함
    sum_of_digits = current_arr[0] + current_arr[1]
    
    # 3. 합계의 가장 오른쪽 자리 수를 구함
    sum_ones_digit = sum_of_digits % 10
    
    # 4. 규칙에 따라 새로운 숫자를 만듦
    new_num = (current_arr[1] * 10) + sum_ones_digit
    
    # 5. 현재 숫자를 새로운 숫자로 갱신
    current_num = new_num
    
    # 6. 새로운 숫자가 최초의 숫자와 같으면 사이클 종료
    if current_num == initial_num:
        break

# 최종 사이클 횟수 출력
print(count)