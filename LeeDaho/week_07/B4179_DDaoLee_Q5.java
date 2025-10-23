import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4179_DDaoLee_Q5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 미로의 행(R), 열(C) 입력
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 미로를 표현할 2차원 char 배열
        char[][] maze = new char[R][C];

        // 지훈이가 방문했는지 확인하는 배열
        boolean[][] jihoonVisited = new boolean[R][C];

        // 불이 번진 곳을 확인하는 배열
        boolean[][] fireVisited = new boolean[R][C];

        // 지훈이의 위치들을 저장할 큐 (BFS 용)
        Queue<int[]> jihoonQueue = new LinkedList<>();

        // 불의 위치들을 저장할 큐 (BFS 용)
        Queue<int[]> fireQueue = new LinkedList<>();

        // 미로 입력 처리
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = line.charAt(j);

                // 지훈이의 시작 위치를 큐에 저장
                if (maze[i][j] == 'J') {
                    jihoonQueue.offer(new int[]{i, j});
                    jihoonVisited[i][j] = true;

                // 불의 시작 위치를 큐에 저장
                } else if (maze[i][j] == 'F') {
                    fireQueue.offer(new int[]{i, j});
                    fireVisited[i][j] = true;
                }
            }
        }

        // 상하좌우 이동을 위한 방향 벡터
        int[] directionX = { -1, 0, 1, 0 };
        int[] directionY = { 0, -1, 0, 1 };

        boolean hasEscaped = false;  // 지훈이 탈출 여부
        int escapeTime = 0;          // 탈출 시간

        // BFS 시작: 지훈이 큐가 빌 때까지(빈 경우, 탈출 실패)
        while (!jihoonQueue.isEmpty()) {
            // === 1단계: 불 먼저 확산 ===
            int fireQueueSize = fireQueue.size();
            for (int i = 0; i < fireQueueSize; i++) {
                int[] currentFire = fireQueue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nextX = currentFire[0] + directionX[dir];
                    int nextY = currentFire[1] + directionY[dir];

                    // 범위를 벗어나거나, 벽이거나, 이미 방문한 경우는 무시
                    if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                    if (maze[nextX][nextY] == '#' || fireVisited[nextX][nextY]) continue;

                    // 불을 퍼뜨림
                    fireQueue.offer(new int[]{nextX, nextY});
                    fireVisited[nextX][nextY] = true;
                    maze[nextX][nextY] = 'F';  // 미로에 불 표시
                }
            }

            // === 2단계: 지훈이 이동 ===
            int jihoonQueueSize = jihoonQueue.size();
            for (int i = 0; i < jihoonQueueSize; i++) {
                int[] currentJihoon = jihoonQueue.poll();
                int currentX = currentJihoon[0];
                int currentY = currentJihoon[1];

                // 현재 위치가 미로의 가장자리면 탈출 성공
                if (currentX == 0 || currentX == R - 1 || currentY == 0 || currentY == C - 1) {
                    hasEscaped = true;
                    // 가장자리에서 탈출하며 시간 +1
                    escapeTime++;
                    break; // 탈출했으니 더 이상 진행할 필요 없음
                }

                // 지훈이의 이동
                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = currentX + directionX[dir];
                    int nextCol = currentY + directionY[dir];

                    // 범위 벗어나거나, 벽, 불, 방문한 곳은 이동 불가
                    if (nextRow < 0 || nextRow >= R || nextCol < 0 || nextCol >= C) continue;
                    if (maze[nextRow][nextCol] == '#' || maze[nextRow][nextCol] == 'F' || jihoonVisited[nextRow][nextCol]) continue;

                    // 이동 가능한 경우 큐에 추가
                    jihoonQueue.offer(new int[]{nextRow, nextCol});
                    jihoonVisited[nextRow][nextCol] = true;
                }
            }

            // 탈출했으면 루프 종료
            if (hasEscaped) break;

            // 한 턴(시간) 경과
            escapeTime++;
        }

        // 결과 출력
        if (hasEscaped) {
            System.out.println(escapeTime);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
