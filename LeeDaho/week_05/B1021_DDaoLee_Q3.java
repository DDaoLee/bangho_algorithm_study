package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B1021_DDaoLee_Q3 {
    public static void main(String[] args) throws IOException {

        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 줄 입력: N (큐 크기), M (뽑아내려는 수의 개수)
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 큐 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑을 수 개수

        // 덱(Deque) 생성 및 1부터 N까지 삽입
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int ans = 0; // 총 회전 횟수 저장 변수
        st = new StringTokenizer(br.readLine()); // 뽑아내려는 수들의 목록 입력

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken()); // 뽑아야 할 수
            int index = 0; // 타겟의 현재 위치 인덱스 (0-based)

            // 덱을 순회하면서 target 위치 찾기
            for (int x : deque) {
                if (x == target) break;
                index++;
            }

            // 타겟이 앞쪽 절반에 있을 때 (왼쪽 회전이 더 효율적)
            if (index <= deque.size() / 2) {
                // index 만큼 왼쪽으로 회전 (맨 앞 원소를 뒤로 보냄)
                for (int j = 0; j < index; j++) {
                    deque.offerLast(deque.pollFirst());
                    ans++; // 회전 횟수 증가
                }
            } 
            // 타겟이 뒤쪽 절반에 있을 때 (오른쪽 회전이 더 효율적)
            else {
                // 뒤에서부터 이동할 횟수 = 전체 크기 - index
                for (int j = 0; j < deque.size() - index; j++) {
                    deque.offerFirst(deque.pollLast());
                    ans++; // 회전 횟수 증가
                }
            }

            // 타겟이 맨 앞에 왔으므로 제거
            deque.pollFirst();
        }

        // 총 회전 횟수 출력
        System.out.println(ans);

    }
}
