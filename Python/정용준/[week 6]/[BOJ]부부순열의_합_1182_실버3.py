import sys
from itertools import combinations
sys.stdin = open('input4.txt', 'r')

n, s = map(int, input().split())
arr = list(map(int, input().split()))

count =  0

for i in range(1, len(arr)+1):
    for j in list(combinations(arr, i)):  
        if sum(j) == s:            
            count += 1

print(count)






