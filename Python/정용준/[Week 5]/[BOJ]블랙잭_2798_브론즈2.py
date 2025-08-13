from itertools  import combinations

# 첫 줄 입력 n, m / n : 카드 개수 m: 목표 숫자
n,m = map(int,input().split())
nums = list(map(int, input().split()))
# 3가지 모든 조합 ([[(5, 6, 7), (5, 6, 8)...])
comb = list(combinations(nums,3))

max_num = 0
#  입력 1에서 모든 조합의 합 (18,19,20,20 ...)
# for j in range(len(comb)):
#     print(sum(comb[j]))


for i in range(len(comb)):
    if(m == sum(comb[i])):
        max_num = sum(comb[i])
    elif (m > sum(comb[i])):
        max_num = max(max_num,sum(comb[i]))
       
print(max_num)