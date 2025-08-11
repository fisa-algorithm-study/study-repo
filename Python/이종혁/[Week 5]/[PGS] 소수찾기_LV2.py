from itertools import permutations

def solution(numbers):
    # numbers의 각 원소를 반복문으로 append?
    # 자기 자신만으로 나누어진다면?
    lst = []
    numbers_list = []
    all_numbers_list = set()
    answer = 0
    # 순열 생성, set에 저장
    for i in range(len(numbers)):
        lst += list(permutations(numbers,i+1))
        for p in lst:
            numbers_list = ''.join(p)
            all_numbers_list.add(int(numbers_list))
    
    for i in all_numbers_list:
        if i < 2:
            continue
        is_prime = True
        for j in range(2, i-1):
            if i % j == 0:
                is_prime = False
                break
        if is_prime:
            answer += 1
                
    
    return answer