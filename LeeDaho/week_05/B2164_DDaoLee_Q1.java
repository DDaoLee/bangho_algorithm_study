package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_DDaoLee_Q1 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 카드의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 큐를 사용하여 덱(카드 더미) 구현
        Queue<Integer> deck = new LinkedList<>();

        // 1부터 N까지의 숫자를 큐에 삽입 (카드 초기 상태)
        for (int i = 1; i <= N; i++) {
            deck.offer(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (true) {
            // 카드가 한 장만 남았다면, 그 카드가 정답
            if (deck.size() == 1) {
                System.out.println(deck.peek()); // 남은 카드 출력
                break; // 종료
            }

            // 1단계: 제일 위의 카드를 버린다 (poll)
            deck.poll();

            // 2단계: 그 다음 카드를 맨 뒤로 보낸다
            deck.offer(deck.peek()); // 맨 앞 카드 복사해서 맨 뒤에 삽입
            deck.poll();             // 그리고 맨 앞 카드는 제거
        }
    }
}
