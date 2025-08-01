import sys

sys.stdin = open("input.txt", "r")

tc, qc = map(int, input().strip().split())

dict, dict2 = {}, {}

for _ in range(tc):
    name = input().strip()
    dict[_+1] = name
    dict2[name] = _+1

for _ in range(qc):
    target = input().strip()
    try :
        print(dict[int(target)])
    except :
        print(dict2[target])