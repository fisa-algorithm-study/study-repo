import sys
from collections import Counter
sys.stdin = open("input.txt", "r")

def checktt(arr, comp):
    for i in range(0,9,3):
        for j in range(0,9,3):
            checked = set()
            for r in range(i,i+3):
                for(c) in range(j, j+3):
                    target = arr[r][c]
                    if target not in checked and target in comp:
                        checked.add(target)
                    else:
                        return False
    return True
 
def checkrowcol(arr, comp):
    for i in range(0,9):
        checked_row = set()
        checked_col = set()
        for j in range(0,9):
            target1 = arr[i][j]
            target2 = arr[j][i]
            if target2 not in checked_row and target1 not in checked_col and target1 in comp and target2 in comp:
                checked_col.add(target1)
                checked_row.add(target2)
            else:
                return False
    return True
      
 
 
 
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    arr = []
    for i in range(9):
        arr.append(list(map(int, input().strip().split(" "))))
   #print(arr)
    comp = [1,2,3,4,5,6,7,8,9]
    if checkrowcol(arr, comp) and checktt(arr, comp):
       print(f'#{test_case} 1')
    else:
       print(f'#{test_case} 0')