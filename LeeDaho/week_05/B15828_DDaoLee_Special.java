package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B15828_DDaoLee_Special {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> router = new LinkedList<>();  // 라우터 버퍼 역할을 하는 큐 생성
        int bufferSize = Integer.parseInt(br.readLine()); // 버퍼 크기 입력

        while (true) {
            int N = Integer.parseInt(br.readLine()); // 명령어 입력

            if (N == -1) break; // -1 입력 시 종료

            if (N == 0) {
                // 0 입력 시 버퍼에서 가장 앞에 있는 패킷 제거 (큐에서 poll)
                router.poll();
            } else if (N != -1) {
                // 0도 아니고 -1도 아닐 때는 패킷 번호를 의미
                // 버퍼 크기가 초과하지 않으면 큐에 패킷 추가
                if (router.size() < bufferSize) router.offer(N);
            }
        }

        // 버퍼에 남아있는 패킷을 모두 출력
        for (int packet : router) {
            sb.append(packet).append(" ");
        }

        // 버퍼가 비어있으면 "empty" 출력, 아니면 남은 패킷 번호 출력
        if (router.size() == 0) System.out.println("empty");
        else System.out.println(sb);
    }
}
