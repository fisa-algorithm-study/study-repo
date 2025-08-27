import sys

sys.stdin = open('input.txt', 'r')

n = int(input())
# 만약 n 값이 10보다 작다면 앞에 0을 붙여 두자리 수로 만들고 각 자리의 숫자를 더한다.
# 주어진 수 의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙여 새로운 수를 만들ㄹ어보자.
count = 0
# 0보다 작은거 어떻게 처리하지
# -> 0보다 작은거 왜 되는지 모르겠음
num = n
# 무한 뻉뻉이
while(True):
    a = num // 10
    b = num % 10
    new_num = b * 10 + (a + b) % 10
    count += 1
    num = new_num
    if(num == n):
        break


print(count)
