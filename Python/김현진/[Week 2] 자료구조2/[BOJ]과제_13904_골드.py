import sys
sys.stdin = open("input.txt", "r")

class Assignment:
    def __init__(self, dline, score):
        self.dline = dline
        self.score = score

    def __lt__(self, other):  # 점수 기준 내림차순
        return (self.score, self.dline) < (other.score, other.dline)

T = int(input())
assignments = []

max_day = 0
for _ in range(T):
    dline, score = map(int, input().strip().split())
    assignments.append(Assignment(dline, score))
    max_day = max(max_day, dline)

# 점수 높은 순으로 정렬
assignments.sort(reverse=True)

visited = [False] * (max_day + 1)
ans = 0

for a in assignments:
    for day in range(a.dline, 0, -1):
        if not visited[day]:
            visited[day] = True
            ans += a.score
            break

print(ans)
