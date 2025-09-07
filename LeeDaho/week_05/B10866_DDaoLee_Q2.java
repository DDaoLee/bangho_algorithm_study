package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B10866_DDaoLee_Q2 {

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 최적화를 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 명령어의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 덱(Deque) 자료구조 생성 (ArrayDeque이 LinkedList보다 성능이 더 좋음)
        Deque<Integer> deque = new ArrayDeque<>();

        StringTokenizer st; // 입력 라인을 명령어와 숫자로 나누기 위한 토크나이저

        // N개의 명령어 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 명령어 입력
            String cmd = st.nextToken(); // 명령어 추출

            switch (cmd) {
                case "push_front":
                    // 정수를 덱의 앞에 삽입
                    int dataFront = Integer.parseInt(st.nextToken());
                    deque.offerFirst(dataFront);
                    break;

                case "push_back":
                    // 정수를 덱의 뒤에 삽입
                    int dataBack = Integer.parseInt(st.nextToken());
                    deque.offerLast(dataBack);
                    break;

                case "pop_front":
                    // 덱이 비어있으면 -1 출력, 아니면 앞의 값을 제거하고 출력
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollFirst()).append("\n");
                    break;

                case "pop_back":
                    // 덱이 비어있으면 -1 출력, 아니면 뒤의 값을 제거하고 출력
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollLast()).append("\n");
                    break;

                case "size":
                    // 현재 덱의 크기 출력
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    // 덱이 비어있으면 1 출력, 아니면 0 출력
                    sb.append(deque.isEmpty() ? "1\n" : "0\n");
                    break;

                case "front":
                    // 덱이 비어있으면 -1 출력, 아니면 맨 앞의 값 출력 (삭제 X)
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekFirst()).append("\n");
                    break;

                case "back":
                    // 덱이 비어있으면 -1 출력, 아니면 맨 뒤의 값 출력 (삭제 X)
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }

        // 전체 출력
        System.out.println(sb);
    }
}
