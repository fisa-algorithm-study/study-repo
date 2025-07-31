from collections import defaultdict

N, M = map(int, input().split())

pokemon_num = defaultdict(str)  # 도감번호로 포켓몬 이름을 찾기위해
pokemon_name = defaultdict(int) # 포켓몬 이름으로 도감번호를 찾기위해

# N개의 포켓몬 등록
for i in range(1, N+1):
    name = input().strip()
    # {'Pikachu' : 1}
    pokemon_num[i] = name
    # {1 : 'Pikachu'}
    pokemon_name[name] = i


# M개의 문제 입력받기
question = [input().strip() for _ in range(M)]

# 문제 풀이
for q in question:
    # 도감번호라면 번호로 포켓몬 이름 찾기
    if q.isdigit():  
        print(pokemon_num[int(q)])

    else:
        # 문자면 도감번호 찾기          
        print(pokemon_name[q])

