import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697_DDaoLee_Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 출발 지점(N)과 목표 지점(K)을 입력받음
        int N = Integer.parseInt(st.nextToken());  // 출발 지점
        int K = Integer.parseInt(st.nextToken());  // 목표 지점

        // BFS를 위한 큐와 방문 여부를 체크할 배열
        Queue<Integer> queue = new LinkedList<>();  
        boolean[] visited = new boolean[100001];  // 방문 여부 체크 배열
        int[] distance = new int[100001];  // 각 지점까지의 최단 거리 배열

        // 시작 지점 큐에 넣기
        queue.offer(N);
        visited[N] = true;  // 출발 지점은 방문 처리

        // BFS 시작
        while(true) {
            int currentPosition = queue.poll();  // 현재 위치 가져오기

            // 목표 지점에 도달하면 거리 반복문 종료
            if(currentPosition == K) {
                break;
            }

            // 현재 위치에서 갈 수 있는 세 가지 경로 탐색: -1, +1, *2
            for (int nextPosition : new int[]{currentPosition - 1, currentPosition + 1, currentPosition * 2}) {
                // nextPosition이 유효한 범위(0 ~ 100000) 내에 있고, 아직 방문하지 않았다면
                if (nextPosition >= 0 && nextPosition <= 100000 && !visited[nextPosition]) {
                    visited[nextPosition] = true;  // 방문 처리
                    queue.offer(nextPosition);  // 큐에 다음 위치 추가
                    distance[nextPosition] = distance[currentPosition] + 1;  // 거리 계산
                }
            }
        }

        // 목표 지점까지의 최단 거리 출력
        System.out.println(distance[K]);
    }
}
