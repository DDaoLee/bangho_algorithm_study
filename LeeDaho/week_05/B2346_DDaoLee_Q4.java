package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B2346_DDaoLee_Q4 {

    // 풍선 객체를 나타내는 내부 클래스
    public static class Balloon {
        int num;    // 풍선 번호
        int shift;  // 다음 이동할 위치를 나타내는 이동 횟수

        // 생성자
        public Balloon(int num, int shift) {
            this.num = num;
            this.shift = shift;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 풍선의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 풍선 정보를 저장할 덱 (Deque) 생성
        Deque<Balloon> balloons = new ArrayDeque<>();

        // 한 줄에 입력된 각 풍선의 이동값 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 각 풍선 번호와 이동값을 Balloon 객체로 만들어 덱에 추가
            balloons.offer(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        // N개의 풍선 중 N-1개를 터뜨리는 과정 반복
        for (int i = 0; i < N - 1; i++) {
            // 현재 가장 앞에 있는 풍선의 이동 값(shift)을 저장
            int shift = balloons.peek().shift;

            // 현재 풍선을 터뜨리고 번호를 결과에 추가
            sb.append(balloons.poll().num).append(" ");

            // 이동 값에 따라 덱을 회전시킴
            if (shift > 0) {
                // shift가 양수이면 앞에서 뒤로 이동 (shift-1)번 수행
                // (이미 한 번 이동한 상태라서 -1을 함)
                for (int j = 0; j < shift - 1; j++) {
                    balloons.offerLast(balloons.pollFirst());
                }
            } else {
                // shift가 음수이면 뒤에서 앞으로 이동 (-shift)번 수행
                for (int j = 0; j < (-1) * shift; j++) {
                    balloons.offerFirst(balloons.pollLast());
                }
            }
        }

        // 마지막으로 남은 풍선 번호를 결과에 추가
        sb.append(balloons.peek().num);

        // 결과 출력
        System.out.println(sb);
    }
}
