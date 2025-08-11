import sys
from collections import deque

# sys.stdin = open("Python/이종혁/[Week4]트리/input_2.txt", "r")
# input = sys.stdin.readline 

N = int(input())

# class Node:
#     def __init__(self, item):
#         self.item = item
#         self.left = None
#         self.right = None

# tree 딕셔너리
tree = dict()
# 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
# 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
# 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)

for _ in range(N):
    root, left, right = input().split()
    tree[root] = (left, right)

# print(tree)
# {'A': ('B', 'C'), 'B': ('D', '.'), 'C': ('E', 'F'),
#  'E': ('.', '.'), 'F': ('.', 'G'), 'D': ('.', '.'), 'G': ('.', '.')}

# 전위 순회 (루트) (왼쪽 자식) (오른쪽 자식)
def preorder(node):
    if node == '.':
        return
    print(node, end='')        # root
    # 재귀적으로
    preorder(tree[node][0])    # left
    preorder(tree[node][1])    # right

# 중위 순회 (왼쪽 자식) (루트) (오른쪽 자식)
def inorder(node):
    if node == '.':
        return
    inorder(tree[node][0])
    print(node, end='')
    inorder(tree[node][1])

# 후위 순회 (왼쪽 자식) (오른쪽 자식) (루트)
def postorder(node):
    if node == '.':
        return
    postorder(tree[node][0])
    postorder(tree[node][1])
    print(node, end='')

preorder('A')
print()
inorder('A')
print()
postorder('A')