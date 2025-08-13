N = int(input())

M_arr = []


result = 0
start = max(1, N-9*len(str(N)))


for M in range(start, N):  
    
    M_arr = []
    for j in str(M):
        M_arr.append(j)
    

    M_small = 0
    for k in range(len(M_arr)):
        M_small += int(M_arr[k])
    M_sum = M_small + M
    if M_sum == N:
        result = M  
        break       

print(result)



