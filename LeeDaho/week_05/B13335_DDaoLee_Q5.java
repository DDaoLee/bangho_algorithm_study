package LeeDaho.week_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B13335_DDaoLee_Q5 {

    // 트럭 정보를 담는 클래스
    public static class Truck {
        int weight;   // 트럭 무게
        int distance; // 다리를 건넌 거리 (시간 단위)

        // 생성자
        public Truck(int weight) {
            this.weight = weight;
            this.distance = 0; // 처음에 다리 위에 없으므로 거리 0으로 초기화
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이 (트럭이 다리를 건너는 데 필요한 시간)
        int L = Integer.parseInt(st.nextToken()); // 다리가 견딜 수 있는 최대 하중

        Deque<Truck> trucks = new ArrayDeque<>(); // 대기 중인 트럭들

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(new Truck(Integer.parseInt(st.nextToken()))); // 트럭 무게 입력받아 대기열에 추가
        }

        int time = 0;            // 경과 시간
        int bridgeWeight = 0;    // 다리 위 트럭들의 총 무게
        Deque<Truck> bridge = new ArrayDeque<>(); // 다리 위 트럭들을 나타내는 덱

        // 대기 중인 트럭 또는 다리 위 트럭이 있을 때까지 반복
        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            time++; // 1초 경과

            // 다리 위 모든 트럭의 이동 거리 1 증가
            for (Truck t : bridge) {
                t.distance++;
            }

            // 다리 위 첫 번째 트럭이 다리를 완전히 건넜으면 다리에서 제거
            if (!bridge.isEmpty() && bridge.peekFirst().distance > w) {
                bridgeWeight -= bridge.pollFirst().weight; // 다리 하중에서 제거
            }

            // 대기 중인 트럭이 남아있고, 다리에 올릴 수 있는 조건을 만족하면 트럭 진입
            if (!trucks.isEmpty()) {
                // 다리에 올렸을 때 하중 초과하지 않고, 다리 길이 제한 내에 있을 때
                if (bridgeWeight + trucks.peek().weight <= L && bridge.size() < w) {
                    bridgeWeight += trucks.peek().weight; // 다리 하중 증가
                    trucks.peek().distance++;              // 다리에 올릴 때 1초 이동한 것으로 처리
                    bridge.offerLast(trucks.pollFirst()); // 트럭 대기열에서 빼서 다리 위에 올림
                }
            }
        }

        // 총 경과 시간 출력
        System.out.println(time);
    }
}
