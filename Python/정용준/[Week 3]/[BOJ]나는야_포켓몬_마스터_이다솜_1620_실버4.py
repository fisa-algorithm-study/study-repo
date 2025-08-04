import sys

sys.stdin = open('input.txt', 'r')

n, m = map(int, input().split())  # 26, 5 입력 받음

# 문제가 숫자이면 배열로 뱉고
pokemon_list = []
#  문제가 영어(이름)이면 숫자를 뱉어야함.
pokemon_num_dict = {}

for i in range(1, n + 1):
    name = input().strip()
    pokemon_list.append(name)
    pokemon_num_dict[name] = i  # 
# print(pokemon_list)
# print(pokemon_num_dict)

for _ in range(m):
    quiz = input().strip()
    if quiz.isdigit(): #숫자면?
        num = int(quiz)
        print(pokemon_list[num - 1])
    else:
        # 숫자가 아니면?
        print(pokemon_num_dict[quiz])







