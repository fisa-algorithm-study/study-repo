import math
import sys

#  이거 그냥 확통문제 아님??
#   29C13 사이트 29개중에서 순서 상관없이  13개의 사이트 고르면 되는거 아닌가 싶다
# 조건이 겹치면 안되고, 같은곳 안되고 그럼 검은공 29개에서 13개를 랜덤으로 뽑는다 
sys.stdin = open('input.txt', 'r')
TestCase = int(input())

for i in range(0,TestCase):
    n,m = map(int, input().split())
    print(math.comb(m,n))

