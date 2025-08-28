N = int(input())

arr = []
for i in range((N // 5) + 1):
    remainder = N - (5 * i)
    
    if remainder % 2 == 0:
        j = remainder // 2
        arr.append(i + j)

if not arr:
    print(-1)
else:
    print(min(arr))