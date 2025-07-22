#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.

# Set은 중복 요소를 제거한다.
# 아이디어는 각각의 행, 열, 3x3 행렬을 set에 넣고, 요소가 9가 아니면 올바르지 않은 스도쿠(answer = 0)
for test_case in range(1, T + 1):
    # 2차원 list 생성
    board = [list(map(int, input().split())) for _ in range(9)] 
    answer = 1

    for row in board: 
        # 스도쿠의 행 중복검사
        # 행의 원소를 set에 넣었을 때, 1~9의 set 집합과 같지 않다면 Flag=0
        if set(row) != set(range(1,10)):
            answer = 0
 	
    for col in range(9):
        col_element = [board[row][col] for row in range(9)]
        if set(col_element) != set(range(1, 10)):
            answer = 0
    
    # 3x3 행렬의 중복 계산을 위해, 0, 3, 6 반복으로 각 3x3 행렬의 시작 좌표 [0][0] [3][0] [6][0] [3][0] [3][3] [3][6] [6][0] [6][3] [6][6] 
    for start_point_row in range(0, 9, 3):
        for start_point_col in range(0, 9, 3):
            block = []
            for i in range(3):
                for j in range(3):
                    # 3x3 배열에 원본 element 삽입
                    block.append(board[start_point_row + i][start_point_col + j])
                    #중복 체크
            if set(block) != set(range(1, 10)):
                answer = 0

    print(f"#{test_case} {answer}")
