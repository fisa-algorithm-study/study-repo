# [우리 FIS 아카데미 5기] 알고리즘 및 코딩 테스트 문제 풀이📖

---

## 👩‍👦‍👦 **스터디 멤버**

<table>
 <tr>
    <td align="center"><a href="https://github.com/Jhcki222"><img src="https://avatars.githubusercontent.com/Jhcki222" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/Yang-Chaeyeon"><img src="https://avatars.githubusercontent.com/Yang-Chaeyeon" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/JBL28"><img src="https://avatars.githubusercontent.com/JBL28" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/wo-oaw"><img src="https://avatars.githubusercontent.com/wo-oaw" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/woni-jo"><img src="https://avatars.githubusercontent.com/woni-jo" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/Ju-Min-Kyung"><img src="https://avatars.githubusercontent.com/Ju-Min-Kyung" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/wjddydwns"><img src="https://avatars.githubusercontent.com/wjddydwns" width="150px;" alt=""></td>
    <td align="center"><a href="https://github.com/blueoxygens"><img src="https://avatars.githubusercontent.com/blueoxygens" width="150px;" alt=""></td>
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Jhcki222"><b>이종혁</b></td>
    <td align="center"><a href="https://github.com/Yang-Chaeyeon"><b>양채연</b></td>
    <td align="center"><a href="https://github.com/JBL28"><b>이정복</b></td>
    <td align="center"><a href="https://github.com/wo-oaw"><b>임건애</b></td>
    <td align="center"><a href="https://github.com/woni-jo"><b>조원희</b></td>
    <td align="center"><a href="https://github.com/Ju-Min-Kyung"><b>주민경</b></td>
    <td align="center"><a href="https://github.com/wjddydwns"><b>정용준</b></td>
    <td align="center"><a href="https://github.com/blueoxygens"><b>김현진</b></td>
  </tr>
  <tr> 
    <td align="center">Python</td>
    <td align="center">Java</td>
    <td align="center">Java<y</td>
    <td align="center">Java</td>
    <td align="center">Java</td>
    <td align="center">Python</td>
    <td align="center">Python</td>
    <td align="center">Python</td>
  </tr> 
</table>

<br />

<br />

## ✅ 스터디 진행 방식과 규칙

### 진행 방식

-   매주 **수요일** 강의 이후 대면 스터디 진행
-   매주 한명씩 돌아가면서 맡은 알고리즘(ex. DFS/BFS, 정렬, 힙..)의 문제를 최대 3개 선정
-   알고리즘의 순서는 [백준 코딩테스트 문제집](https://github.com/tony9402/baekjoon/tree/main)의 순번 그대로 진행합니다.(자료구조 -> 자료구조2 -> 트리 ->...)
-   다만, 해당 알고리즘에 해당하는 문제는 플랫폼 제한없이 자유롭게 선정합니다. (BOJ, 프로그래머스 등..)
-   금요일까지 문제 선정 후, 해당 문제를 포함한 **README를 직접 작성**하고 Slack에 공지
-   월요일까지 각자 브랜치에서 문제 풀이 후, PR 올리기
-   **수요일 스터디 전까지 상대방의 PR에 Code Review를 남기기!**
-   대면 스터디에서 각자 구두로 자신의 코드 리뷰 후, Main 브랜치에 머지합니다.

|      월       |      화       |    수    | 목  |     금     | 토  | 일  |
| :-----------: | :-----------: | :------: | :-: | :--------: | :-: | :-: |
| `과제제출 PR` | `Code Review` | `스터디` |     | `문제공지` |     |     |

## ✅ PR code review

### 각자 브랜치 이름은 자유입니다. 파일 및 커밋 규칙만 잘 지켜주세요🙏

#### Pull Request로 리뷰하는 방법

-   [Pull Request 보내는 법](https://wayhome25.github.io/git/2017/07/08/git-first-pull-request-story/)

```
-   Pull Request 규칙 : [문제출처] 이름 / 주차
-   Ex : [BOJ] 이종혁 / 1주차
```

-   리뷰 방식 - 잘한 것은 과감하게 칭찬하기 Ex) ~님, 배열 인덱싱 한거 엄청 깔끔하네요. <br/>
-   다른 풀이 방법이 있으면 간단히 소개 Ex) 이 문제는 재귀함수로 풀면 더 간단할거 같아요. <br/>
-   개선 필요한 부분 구체적으로 설명 Ex) 통과는 잘 됐는데, 시간 복잡도 측면에서 O(N^2) → O(N) 개선 가능성 있어 보여요.
    <br />

## ✅ 파일명 규칙

```
-   소스코드 파일 명: [문제 플랫폼] 문제이름_번호(Optional)_난이도
    Ex. [BOJ] 사탕게임_3085_브론즈3.java , [PGS] 베스트엘범_Lv3.py
```

<br />

## ✅ commit 규칙

-   commit 메세지: **[문제 플랫폼] 이름 / 문제이름 / 난이도 / 걸린시간**
-   description: 문제 주소 (optional)
-   터미널에서 작성법:

```
git commit -m "[PGS] 이종혁 / Hello World / 브론즈5 / 10 "
```

-   플랫폼 작성법 통일:
    -   [BOJ] - 백준
    -   [PGS] - 프로그래머스
    -   [LTC] - 리트코드
    -   [CFS] - 코드포스
    -   [SEA] - 삼성SW Expert Academy
    -   [ETC] - 그외

<br />

## ✅ 디렉토리 구조

```
└── 📂 Java
       ├── 📂 이정복
       |      ├── 📂 [Week 1]자료구조
                          ├── 💾[BOJ] 풍선 터뜨리기_2346_실버3.java
                          ├── 💾[PGS] 올바른 괄호_LV2.java
       |      ├── 📂 [Week 2]자료구조2
                          ├── 💾[BOJ] ....java
                          ├── 💾[PGS] ....jva
       |      └── 📂 [Week 3]트리
       ├── 📂 임건애

. . .

└── 📂Python
      ├── 📂 이종혁
       |      ├── 📂 [Week 1]자료구조
                          ├── 💾[BOJ] 풍선 터뜨리기_2346_실버3.py
                          ├── 💾[PGS] 올바른 괄호_LV2.py
       |      ├── 📂 [Week 2]자료구조2
                          ├── 💾[BOJ] ....py
                          ├── 💾[PGS] ....py
       |      └── 📂 [Week 3]트리
       │

💾README.md
```

## ✅ 문제 리스트 (1주차 : 2025.07.14~)

**[ 문제 선정 ]**

> 문제는 [Solved.ac](https://solved.ac/), [코딩테스트 대비 문제집](https://github.com/tony9402/baekjoon) 및 [프로그래머스](https://programmers.co.kr/)를 참고한다.

| 주차  | 날짜     | 기출 유형                                            | 문제명                                                                                                                                                                                                                                                                                                              |                                                                                     난이도                                                                                      | 담당자 |
| ----- | -------- |--------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :----: |
| Week1 | 25.07.14 | Data Structure(자료구조)                             | [풍선 터뜨리기](https://www.acmicpc.net/problem/2346)<br />[올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)<br />                                                                                                                                                                             |                                          <img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/> <br/> Lv.2                                           | 이종혁 |
| Week2 | 25.07.21 | Data Structure2(자료구조)                            | [단어 공부](https://www.acmicpc.net/problem/1157)<br />[스도쿠 검증](https://shorturl.at/Lu8fc)<br />[과제](https://www.acmicpc.net/problem/13904)<br />                                                                                                                                                                    | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/5.svg"><br/>D2 <br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/13.svg"/> | 임건애 |
| Week3 | 25.07.30 | Data Structure3(자료구조)                            | [나는야 포켓몬 마스터 이다솜](https://www.acmicpc.net/problem/1620)<br />[영단어 암기는 괴로워](https://www.acmicpc.net/problem/20920)<br />                                                                                                                                                                                          | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/7.svg"/> <br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/>     | 조원희 |
| Week4 | 25.08.06 | Tree(트리)                                         | [트리인가?](https://www.acmicpc.net/problem/6416)<br />[트리의 부모 찾기](https://www.acmicpc.net/problem/11725)<br/>[트리 순회](https://www.acmicpc.net/problem/1991)<br />[양 구출 작전](https://www.acmicpc.net/problem/16437)<br />                                                                                              | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/0.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/10.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/13.svg"/><br/>  | 이정복 |
| Week5 | 25.08.13 | Brute Force Search(완전탐색)                         | [블랙잭](https://www.acmicpc.net/problem/2798)<br/>[분해합](https://www.acmicpc.net/problem/2231)<br/>[소수찾기](https://school.programmers.co.kr/learn/courses/30/lessons/42839)<br/>[바이러스 (그래프)](https://www.acmicpc.net/problem/2606)<br/>[전력망을 둘로 나누기](https://school.programmers.co.kr/learn/courses/30/lessons/86971) |<img height="20px" width="25px" src="https://static.solved.ac/tier_small/4.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/4.svg"/><br/>Lv.2 <br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/> <br/>Lv.2<br/> | 조원희 |
| Week6 | 25.08.20 | Mathematics(수학)<br/><br/><br/>Backtracking(백트래킹) | [더하기 사이클](https://www.acmicpc.net/problem/1110)<br/>[에라토스테네스의 체](https://www.acmicpc.net/problem/2960)<br/><br/>[N과 M(1)](https://www.acmicpc.net/problem/15649)<br/>[부분 수열의 합](https://www.acmicpc.net/problem/1182)<br/>[스도쿠](https://www.acmicpc.net/problem/2580)<br/>                                       |   <img height="20px" width="25px" src="https://static.solved.ac/tier_small/5.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/7.svg"/><br/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/12.svg"/><br/>  | 조원희 |
| Week7 | 25.08.27 | Greedy1(그리디) | [거스름돈](https://www.acmicpc.net/problem/14916)<br/>[문서 검색](https://www.acmicpc.net/problem/1543)<br/>[체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862)<br/>[카약과 강풍](https://www.acmicpc.net/problem/2891)<br/>[등수 매기기](https://www.acmicpc.net/problem/2012)<br/> | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/6.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/6.svg"/><br/>Lv.1<br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/7.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/><br/>  | 조원희 |
| Week8 | 25.09.03 | Greedy2(그리디) | 지붕잃고 외양간 고치기<br/>[강의실 배정](https://www.acmicpc.net/problem/11000)<br/>[섬 연결하기](https://school.programmers.co.kr/learn/courses/30/lessons/42861) | -<br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/12.svg"/><br/>Lv.3 | 조원희 |
| Week9 | 25.09.10 | Dynamic Programming1(동적 계획법) | [다리 놓기](https://www.acmicpc.net/problem/1010)<br/>[1로 만들기](https://www.acmicpc.net/problem/1463)| <img height="20px" width="25px" src="https://static.solved.ac/tier_small/6.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/>  | 조원희 |
| Week10 | 25.09.17 | Dynamic Programming2(동적 계획법) | [가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)<br/>[가장 긴 바이토닉 부분 수열](https://www.acmicpc.net/problem/11054)<br/>[정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105)<br/>[0/1 Knapsack](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr&)| <img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/12.svg"/> </br> Lv.3</br>D3 | 조원희 |
| - | 25.09.24 | [백엔드 기술 세미나] | - | - | - |
| Week11 | 25.10.01 | Data Structure(자료구조)<br/>&nbsp;&nbsp;&nbsp;- Heap(힙)<br/>&nbsp;&nbsp;&nbsp;- Priority Queue(우선순위 큐)<br/><br/>Graph Theory(그래프 이론)|[최대 힙](https://www.acmicpc.net/problem/11279)<br/>[최소 힙](https://www.acmicpc.net/problem/1927)<br/>[더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626)<br/><br/>[연결 요소의 개수](https://www.acmicpc.net/problem/11724)| <img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/>Lv.2<br/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/> | 조원희 |
| - | 25.10.08 | [추석] | - | - | - |
| Week12 | 25.10.15 | Two Pointers(투 포인터)<br/>Sliding Window(슬라이딩 윈도우)<br/>Range Sum(구간합)<br/>Prefix Sum(누적합)|[두 수의 합](https://www.acmicpc.net/problem/3273)<br/>[연속된 부분 수열의 합](https://school.programmers.co.kr/learn/courses/30/lessons/178870)<br/>[꿀 아르바이트](https://www.acmicpc.net/problem/12847)<br/>[수열](https://www.acmicpc.net/problem/2559)<br/>[부분합](https://www.acmicpc.net/problem/1806)<br/>[나머지 합](https://www.acmicpc.net/problem/10986)| <img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/><br/>Lv.2<br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/><br/> <img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/12.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/12.svg"/>| 조원희 |
| Week13 | 25.10.22 | Prefix Sum(누적합) | [피아노 체조](https://www.acmicpc.net/problem/21318)<br/>[파괴되지 않은 건물](https://school.programmers.co.kr/learn/courses/30/lessons/92344) | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/10.svg"/><br/>Lv.3 | 조원희 |
| Week14 | 25.10.29 | DFS BFS1(깊이/넓이 우선 탐색) | [DFS와 BFS](https://www.acmicpc.net/problem/1260)<br/>[숨바꼭질](https://school.programmers.co.kr/learn/courses/30/lessons/1697)<br/>[게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)<br/>[네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)<br/> | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/><br/><img height="20px" width="25px" src="https://static.solved.ac/tier_small/10.svg"/><br/>Lv.2<br/>Lv.3 | 조원희 |
| Week15 | 25.11.05 | DFS BFS2(깊이/넓이 우선 탐색) | [미로2](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD)<br/>[보급로](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD)<br/>[파핑파핑 지뢰찾기](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LwsHaD1MDFAXc&)<br/>|D4<br/>D4<br/>D4 | 조원희 |
