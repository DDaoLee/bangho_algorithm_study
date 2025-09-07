package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10845_DDaoLee_Q0 {

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 결과를 모아서 한 번에 출력하기 위한 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 명령의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 정수형 큐 생성 (Queue 인터페이스를 LinkedList로 구현)
        Queue<Integer> queue = new LinkedList<>();

        StringTokenizer st;
        int backData = 0; // 큐의 가장 마지막에 삽입된 데이터를 저장하는 변수

        // N개의 명령 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); // 한 줄 명령어를 토큰으로 분리
            String cmd = st.nextToken(); // 명령어 부분 추출

            switch (cmd) {
                case "push":
                    // push 명령: 정수를 큐에 삽입하고, backData에 저장
                    int data = Integer.parseInt(st.nextToken());
                    backData = data;
                    queue.offer(data);
                    break;

                case "pop":
                    // pop 명령: 큐가 비어있지 않으면 front 값 제거 후 출력, 비어있으면 -1 출력
                    if (!queue.isEmpty()) sb.append(queue.poll()).append("\n");
                    else sb.append(-1).append("\n");
                    break;

                case "size":
                    // size 명령: 현재 큐의 크기 출력
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    // empty 명령: 큐가 비어있으면 1, 아니면 0 출력
                    if (!queue.isEmpty()) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;

                case "front":
                    // front 명령: 큐의 가장 앞에 있는 값 출력, 비어있으면 -1 출력
                    if (!queue.isEmpty()) sb.append(queue.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;

                case "back":
                    // back 명령: 큐가 비어있지 않으면 마지막으로 삽입된 값 출력 (backData), 비어있으면 -1 출력
                    if (!queue.isEmpty()) sb.append(backData).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }

        // 모든 출력 결과를 한 번에 출력
        System.out.println(sb);
    }
}
