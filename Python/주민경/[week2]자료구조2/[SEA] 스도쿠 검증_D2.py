T = int(input())
square_start = [(0,0), (0,3), (0,6), (3,0), (3,3), (3,6), (6,0), (6,3), (6,6)]
answer = [True for _ in range(T)]

for t in range(T):
    s = []
    for _ in range(9):
        s.append(list(map(int, input().split())))

    # 행 검사
    for row in s:
        if len(set(row)) != 9 or sum(row) != 45:
            answer[t] = False
            break
    else:
        # 열 검사
        for col in zip(*s):
            if len(set(col)) != 9 or sum(col) != 45:
                answer[t] = False
                break
        else:
            # 3x3 
            for sx, sy in square_start:
                nums = []
                for dx in range(3):
                    for dy in range(3):
                        nums.append(s[sx + dx][sy + dy])
                if len(set(nums)) != 9 or sum(nums) != 45:
                    answer[t] = False
                    break

for i in range(len(answer)):
  if answer[i] == False:
    print(f"#{i+1} 0")
  else:
    print(f"#{i+1} 1")
