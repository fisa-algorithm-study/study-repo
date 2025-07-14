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
  </tr>
  <tr>
    <td align="center"><a href="https://github.com/Seongho0503"><b>이종혁</b></td>
    <td align="center"><a href="https://github.com/Mosquito0076"><b>양채연</b></td>
    <td align="center"><a href="https://github.com/Juwon-Kiim"><b>이정복</b></td>
    <td align="center"><a href="https://github.com/cssopy"><b>임건애</b></td>
    <td align="center"><a href="https://github.com/lea-hwang"><b>조원희</b></td>
    <td align="center"><a href="https://github.com/lea-hwang"><b>주민경</b></td>
  </tr>
  <tr> 
    <td align="center">Python</td>
    <td align="center">Java</td>
    <td align="center">Java<y</td>
    <td align="center">Java</td>
    <td align="center">Java</td>
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
-   수요일 스터디 전까지 상대방의 PR에 Code Review를 남기고, 해당 PR에 대한 Approve **(승인은 3명 이상되어야 Main에 Merge 가능**)
-   대면 스터디에서 각자 구두로 자신의 코드 리뷰 후, Main 브랜치에 머지합니다.

|      월       |      화       |    수    | 목  |     금     | 토  | 일  |
| :-----------: | :-----------: | :------: | :-: | :--------: | :-: | :-: |
| `과제제출 PR` | `Code Review` | `스터디` |     | `문제공지` |     |     |

## ✅ PR code review

### 각자 브랜치 이름은 자유입니다. 파일 및 커밋 규칙만 잘 지켜주세요🙏

#### Pull Request로 리뷰하는 방법

-   [Pull Request 보내는 법](https://wayhome25.github.io/git/2017/07/08/git-first-pull-request-story/)

-   리뷰 방식 - 잘한 것은 과감하게 칭찬하기 Ex.) ~님, 배열 인덱싱 한거 엄청 깔끔하네요. - 다른 풀이 방법이 있으면 간단히 소개 Ex.) 이 문제는 재귀함수로 풀면 더 간단할거 같아요. - 개선 필요한 부분 구체적으로 설명 Ex.) 통과는 잘 됐는데, 시간 복잡도 측면에서 O(N^2) → O(N) 개선 가능성 있어 보여요.
    <br />

## ✅ 파일명 규칙

-   소스코드 파일 명: **[문제 플랫폼] 문제이름* 난이도*번호(Optional)**
    Ex ) [BOJ] 사탕게임*3085*브론즈3.java , [PGS] 베스트엘범\_Lv3.py

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
       ├── 📂 임건

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

| 주차  | 날짜     | 기출 유형                 | 문제명                                                                                                                                          |                                            난이도                                            |  풀이여부  |
| ----- | -------- | ------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------------: | :--------: |
| Week1 | 25.07.14 | Data Structure(자료구조)  | [풍선 터뜨리기](https://www.acmicpc.net/problem/2346)<br />[올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)<br /> | <img height="20px" width="25px" src="https://static.solved.ac/tier_small/8.svg"/> <br/> Lv.2 | ✅<br />✅ |
| Week2 | 25.07.21 | Data Structure2(자료구조) |                                                                                                                                                 |                                                                                              |            |
