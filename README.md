# 🖥 방호팀 코딩테스트 스터디

<table>
    <td>플랫폼</td>
    <td>백준</td>
  </tr>
  <tr>
    <td>언어</td>
    <td>
        <img src="https://img.shields.io/badge/Python-3776AB?style=for-the-badge&logo=python&logoColor=white">
        <img src="https://img.shields.io/badge/C++-00599C?style=for-the-badge&logo=cplusplus&logoColor=white">
        <img src="https://img.shields.io/badge/Java-007396.svg?&style=for-the-badge&logo=Java&logoColor=white"> 
    </td>
  </tr>
</table>

### 운영 방식

- 주마다 지정된 문제를 풀이한다.
- 각자 문제를 풀고 마감 시간 전에 제출한다.
- 해당 주차에 모든 문제 + 스페샬 문제까지 풀면 해당 인원에게 이다호 중위가 음료수를 쏜다. 
  
## ✔️ 이번 주 문제


| 주차 | 문제 유형 | 문제 | 난이도 | 비고 |
|:---:|:---:|:---:|:---:|:---:|
| WEEK_07  | BFS | <p align=left> 1️⃣ [그림](https://www.acmicpc.net/problem/1926) <br> 2️⃣ [미로 탐색](https://www.acmicpc.net/problem/2178) <br> 3️⃣ [숨바꼭질](https://www.acmicpc.net/problem/1697) <br> 4️⃣ [토마토](https://www.acmicpc.net/problem/7576) <br> 5️⃣ [불!](https://www.acmicpc.net/problem/4179) </p> | <p> <img height="20px" width="25px" src="https://static.solved.ac/tier_small/9.svg"/> <br> <img height="20px" width="25px" src="https://static.solved.ac/tier_small/10.svg"/> <br> <img height="20px" width="25px" src="https://static.solved.ac/tier_small/10.svg"/><br> <img height="20px" width="25px" src="https://static.solved.ac/tier_small/10.svg"/> <br> <img height="20px" width="25px" src="https://static.solved.ac/tier_small/11.svg"/>   <br>   <img height="20px" width="25px" src="https://static.solved.ac/tier_small/13.svg"/> </p> | <p align=center> DFS는 추후 그래프나 트리를 <br> 배운 후 다루도록 하겠습니다.|


## 🧑🏻‍💻 진행 상황

| 진행 상황            | 표기  |
|:-----------------|:----|
| 해당 주에 완료 시       | ✅   |
| 해당 주에 부분 완료 시    | 🔢  |
| 해당 주에 미완료 시      | ❌   |


## ▶ 📝[주차별 문제 이력](https://github.com/DDaoLee/bangho_algorithm_study/blob/main/docs/weekly_schedule.md)
## ▶ 📝[주차별 진행도](https://github.com/DDaoLee/bangho_algorithm_study/blob/main/docs/weekly_progress.md)



| 일자 | 문제 | KimJiseok | AhnSuho | LeeDaho | KimDoyun |
|:-------:|:-------:|:-------:|:-------:|:-------:|:-------:| 
| WEEK_07  | 1️⃣<br>2️⃣<br>3️⃣<br>4️⃣<br>5️⃣  |    ❌<br>❌<br>❌<br>❌<br>❌    |     ❌<br>❌<br>❌<br>❌<br>❌     |     ❌<br>❌<br>❌<br>❌<br>❌<br>❌     |     ❌<br>❌<br>❌<br>❌<br>❌<br>❌     |   
---

<br>

## 🔍 참여 방법

1. 이 Repository를 `fork` 하여 복제한 후, 자신의 Github 계정으로 복사한다.
2. 복사한 Repository에서 문제를 푼 뒤, 풀이한 소스 코드를 `commit & push` 한다. ※ commit을 수행할 땐, commit 컨벤션을 지킨다.
3. 원본 저장소로 `pull request`한다. 
<br/>

## 📁 Repository 폴더 구조
### 💡 Github ID/주차/소스코드(플랫폼, 문제 번호와 본인 이름 명시)
### 💡 예시)  `leedaho/week_01/B100_이름.py`

<br>

## ⚠️ commit 컨벤션
### 💡 태그: B+문제번호_본인이름
### 💡 예시) `feat: B100_LeeDaho`
### 📌태그
| 태그       | 설명                      |
|:---------|:------------------------|
| feat     | 기능 추가               |
| fix      | 오류 수정                     |
| refactor | 코드 리팩토링                 |
| docs     | README와 같은 문서 수정        |
| test     | 테스트 또는 테스트 코드 추가  |
| style    | 코드 의미에 영향이 없는 변경  |
| chore    | 자잘한 수정                  |
| rename   | 파일, 폴더명 수정 혹은 이동        |
| remove   | 파일, 폴더 삭제                   |


<br/>

---

### 어떻게 하는지 모르겠어요.

0. (처음 1회만) Repository Fork & Clone 및 Upstream 등록
- 해당 프로젝트에서 “fork” 버튼 클릭 후 fork 생성
- 로컬 저장소에 해당 프로젝트를 clone
```
git clone https://github.com/DDaoLee/bangho_algorithm_study.git
cd bangho_algotithm_study
```
   - upstream 등록
```
git remote add upstream https://github.com/DDaoLee/bangho_algorithm_study.git
```
1. 최신 main 브랜치로 동기화하기
```
git fetch upstream
git checkout main
git merge upstream/main
```
2. 새 브랜치 생성하기
```
git checkout -b <브랜치 이름>
```
3. 자신의 폴더에 문제풀이코드 작성 후 commit & push
```
git add .
git commit -m "feat: B100_LeeDaho" # commit 컨벤션을 지킨다.
git push origin <브랜치 이름>
```
4. Github로 가서 Pull Request 생성
<br>👉 “Compare & pull request” 버튼 클릭
<br>👉 설명 적고 PR 생성
<br>👉 스터디장이 merge 해줄 때까지 기다리면 끝!
<br>
✨사용한 branch들은 merge 이후 시간날때마다 정리해주시면 됩니다.

---

해당 README는 다음 레포지토리를 참고해서 제작하였습니다.

- [CodeSquad-2023-BE-Study](https://github.com/CodeSquad-2023-BE-Study/Algorithm-Study/blob/main/README.md)
