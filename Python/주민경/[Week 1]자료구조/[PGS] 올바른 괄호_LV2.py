def solution(s):
    answer = False
    stack = [n for n in s]
    openStack = []

    for k in stack:
        if k == "(":
            openStack.append("(")
        else:
            if openStack:
                openStack.pop()
            else:
                return answer
    
    if not openStack:
        answer = True
    
    return answer
