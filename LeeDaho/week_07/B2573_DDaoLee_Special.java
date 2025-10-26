import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2573_DDaoLee_Special {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 행, M: 열
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 빙산 지도 정보 입력
        int[][] iceberg = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 탐색을 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        int icebergPieces = 0;          // 현재 남아있는 빙산 조각 수
        boolean isSeperated = false;    // 빙산이 두 조각 이상으로 분리되었는지 여부
        boolean isMeltedAll = true;     // 모든 빙산이 녹았는지 여부
        int year = 0;                    // 지나간 년 수

        // 상하좌우 이동을 위한 방향 배열
        int[] directionX = {1, 0, -1, 0};
        int[] directionY = {0, -1, 0, 1};

        while(true){
            // 1년마다 초기화되는 변수들
            icebergPieces = 0;                      // 해마다 빙산 조각 수 초기화
            boolean[][] currentVisited = new boolean[N][M];  // 해마다 빙산 체크용
            int[][] currentMeltData = new int[N][M];        // 해마다 녹는 양 기록
            isMeltedAll = true;                      // 해마다 빙산이 남아있는지 확인
            
            // 지도 전체 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    // 빙산이 남아있고 아직 방문하지 않은 경우
                    if(iceberg[i][j] > 0 && !currentVisited[i][j]){
                        icebergPieces++;             // 빙산 조각 수 증가
                        // 두 번째 빙산 조각 발견 시, 분리됨
                        if(icebergPieces == 2) {
                            isSeperated = true;
                            break;
                        }

                        isMeltedAll = false;        // 빙산이 존재하므로 true로 변경

                        queue.offer(new int[]{i, j});
                        currentVisited[i][j] = true;

                        // BFS로 현재 빙산 조각 탐색
                        while(!queue.isEmpty()){
                            int[] current = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nextX = current[0] + directionX[dir];
                                int nextY = current[1] + directionY[dir];

                                // 지도 범위 벗어나면 무시
                                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                               
                                // 인접한 칸이 바다이면 녹는 양 증가
                                if(iceberg[nextX][nextY] == 0) {
                                    currentMeltData[current[0]][current[1]]++;
                                } 
                                // 아직 방문하지 않은 빙산이면 큐에 추가
                                else if (!currentVisited[nextX][nextY]) {
                                    queue.offer(new int[]{nextX, nextY});
                                    currentVisited[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                }
            }

            // 빙산이 두 조각 이상으로 분리되면 종료
            if(isSeperated) break;

            // 모든 빙산이 녹으면 0 출력 후 종료
            if(isMeltedAll) {
                year = 0;
                break;
            }

            // 해마다 녹는 양 반영
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(iceberg[i][j] > 0){
                        iceberg[i][j] = Math.max(0, iceberg[i][j] - currentMeltData[i][j]);
                    }
                }
            }
            
            year++; // 1년 증가
        }

        // 결과 출력
        System.out.println(year);
    }
}
