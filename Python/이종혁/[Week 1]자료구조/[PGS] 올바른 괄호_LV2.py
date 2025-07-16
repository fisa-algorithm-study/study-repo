def solution(s):
    sum = 0
    
    # Idea : 처음 괄호부터 체크할 때, ')'가 하나 더 많아지는 순간, 
    # 그 괄호는 올바르지 않은 괄호가 된다. (break로 빠져나옴)
    # 근데 스택으로 풀라네 ;;
    for i in s:
        if i == '(' :
            sum += 1
        else :
            sum -= 1
        if sum < 0 : # sum이 0보다 작아지는 순간, break
            break
    
    if sum == 0 : # 반복문 끝나고, sum이 0이라면 True
        return True
    else : 
        return False # 아니라면 False
            



