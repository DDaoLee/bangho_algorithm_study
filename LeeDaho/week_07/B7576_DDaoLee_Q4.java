import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576_DDaoLee_Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로 크기
        int N = Integer.parseInt(st.nextToken()); // 세로 크기

        // 토마토 박스를 나타내는 배열
        int[][] tomatoBox = new int[N][M];
        // 방문 여부를 체크하는 배열
        boolean[][] visited = new boolean[N][M];
        // 익은 토마토의 위치를 저장하는 큐
        Queue<int[]> queue = new LinkedList<>();

        // 입력 받기 및 익은 토마토 위치 큐에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());

                // 익은 토마토를 큐에 추가하고 방문 처리
                if (tomatoBox[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 4방향 (상, 하, 좌, 우) 이동을 위한 배열
        int[] directionX = new int[]{1, 0, -1, 0};
        int[] directionY = new int[]{0, -1, 0, 1};

        int days = 0; // 토마토가 모두 익는 데 걸린 시간
        int processedCount = 0; // 한 번에 처리한 토마토 수
        int queueSize = queue.size(); // 현재 큐에 있는 익은 토마토의 수

        // BFS 시작
        while (!queue.isEmpty()) {
            // 한 번에 처리한 토마토 수가 큐의 크기와 같으면 시간 증가
            if (processedCount == queueSize) {
                processedCount = 0; // 처리한 토마토 수 초기화
                queueSize = queue.size(); // 큐의 크기 갱신
                days++; // 하루가 지나면 시간 증가

                // 각 시간대마다 상태 출력 (디버깅용)
                // for (int i = 0; i < N; i++) {
                //     for (int j = 0; j < M; j++) {
                //         System.out.print(tomatoBox[i][j] + " ");
                //     }
                //     System.out.println();
                // }
                // System.out.println();
            }

            // 큐에서 하나의 익은 토마토 위치 꺼내기
            int[] current = queue.poll();

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nextX = current[0] + directionX[dir];
                int nextY = current[1] + directionY[dir];

                // 유효한 범위인지 체크
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

                // 이미 익은 토마토거나 벽이 있으면 건너뛰기
                if (tomatoBox[nextX][nextY] != 0 || visited[nextX][nextY]) continue;

                // 익지 않은 토마토를 익힌다
                visited[nextX][nextY] = true;
                tomatoBox[nextX][nextY] = 1;
                queue.offer(new int[]{nextX, nextY}); // 큐에 추가
            }

            // 처리한 토마토 수 증가
            processedCount++;
        }

        // 모든 토마토가 익었는지 확인
        boolean allRipe = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoBox[i][j] == 0) {
                    allRipe = false; // 하나라도 익지 않은 토마토가 존재
                    break;
                }
            }
        }

        // 모든 토마토가 익었으면 걸린 시간 출력, 아니면 -1 출력
        if (allRipe) {
            System.out.println(days); // 모든 토마토가 익었을 때 걸린 시간 출력
        } else {
            System.out.println(-1); // 익을 수 없으면 -1 출력
        }
    }
}
