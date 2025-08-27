from itertools import permutations
import math
def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    if n % 2 == 0:
        return False
    limit = math.isqrt(n)
    for i in range(3, limit + 1, 2):
        if n % i == 0:
            return False
    return True

def solution(numbers):
    num_list = [int(i) for i in str(numbers)]
    
    # 1~N자리 모든 순열 → 정수 → 중복 제거
    candidates = set()
    for r in range(1, len(num_list) + 1):
        for p in permutations(num_list, r):
            candidates.add(int(''.join(map(str, p))))
    
    # 소수이면 카운터 1 추가
    count = 0
    for x in candidates:
        if is_prime(x):
            count += 1
    
    return count
