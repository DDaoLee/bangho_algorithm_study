package LeeDaho.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_DDaoLee_Q1 {

    // 타워 클래스를 정의 각 타워는 높이, 위치, 그리고 신호를 가짐
    public static class Tower {
        int height;   // 타워의 높이
        int location; // 타워의 위치 (1부터 시작)
        int signal;   // 타워가 신호를 받는 타워의 위치 (0이면 신호 없음)

        // 생성자: 높이와 위치를 입력받아 타워 객체를 생성
        public Tower(int height, int location) {
            this.height = height;
            this.location = location;
            this.signal = 0; // 초기 신호값은 0 (신호 없음)
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 결과를 효율적으로 저장하기 위한 StringBuilder

        // 타워의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 타워들의 높이를 공백 기준으로 입력받기 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 타워 객체를 저장할 배열 생성
        Tower[] tower = new Tower[N];

        // 타워의 높이와 위치를 배열에 저장
        for (int i = 0; i < tower.length; i++) {
            tower[i] = new Tower(Integer.parseInt(st.nextToken()), i + 1); // i+1은 타워의 위치 (1-based index)
        }

        // 타워들을 처리하기 위한 Stack 객체
        Stack<Tower> stack = new Stack<>();

        // 각 타워에 대해 신호를 받는 타워의 위치를 계산
        for (int i = 0; i < tower.length; i++) {

            // 현재 타워
            Tower currentTower = tower[i];

            // 스택에 있는 타워들과 비교하며 현재 타워보다 작은 타워는 제거
            // 현재 타워가 더 크므로 신호를 보낼 수 없음
            while (!stack.isEmpty() && stack.peek().height < currentTower.height) {
                stack.pop();
            }

            // 스택이 비지 않았으면, 가장 최근의 큰 타워가 신호를 받을 타워
            if (!stack.isEmpty()) currentTower.signal = stack.peek().location;

            // 현재 타워를 스택에 추가
            stack.push(currentTower);
        }

        // 각 타워의 신호를 결과에 출력
        for (int i = 0; i < tower.length; i++) {
            sb.append(tower[i].signal).append(" "); // 신호 값을 공백으로 구분하여 출력
        }

        // 결과 출력
        System.out.println(sb);
    }
}
