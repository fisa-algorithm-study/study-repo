import sys

N, K = map(int, sys.stdin.readline().split())

arr = []
for i in range(N-1):
    arr.append(i+2)

count = 0 

# K번 숫자를 지울 때까지 
while count < K:
    
    # arr[0]는 항상 남아있는 수 중 가장 작다.
    prime = arr[0]
    
    for num in arr:
        
        if num % prime == 0:
            
            arr.remove(num)
            
            count += 1
            
            if count == K:
                answer = num
                break 
    
    if count == K:
        break

print(answer)