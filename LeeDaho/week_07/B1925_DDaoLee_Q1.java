

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1925_DDaoLee_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 종이의 크기 n (세로), m (가로) 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 세로 크기
        int m = Integer.parseInt(st.nextToken());  // 가로 크기

        // 종이를 나타내는 2D 배열 (종이에 그려진 그림 정보)
        int[][] paper = new int[n][m];

        // 종이의 각 칸에 대한 정보 입력 받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());  // 0 또는 1 입력
            }
        }

        // 방문 여부를 체크할 배열 (그림을 방문했는지 여부)
        boolean[][] visited = new boolean[n][m];

        // 상, 하, 좌, 우로 이동할 때 사용할 델타 배열 (4방향 탐색)
        int[] directionX = {1, 0, -1, 0};  // 오른쪽, 아래, 왼쪽, 위
        int[] directionY = {0, 1, 0, -1};

        // 큐를 사용하여 BFS 탐색을 위한 초기화
        Queue<int[]> queue = new LinkedList<>();

        // 그림의 개수와 가장 큰 그림의 크기
        int pictureCount = 0;  // 그림의 개수
        int maxPictureSize = 0;  // 가장 큰 그림의 크기

        // 2D 배열을 탐색하면서 그림을 찾는 과정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 그림이 있고, 아직 방문하지 않았다면 BFS를 시작
                if(paper[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;  // 해당 칸을 방문 처리
                    queue.offer(new int[]{i, j});  // 큐에 현재 위치 넣기
                    pictureCount++;  // 그림의 개수 증가
                    int currentPictureSize = 1;  // 현재 그림의 크기 (1부터 시작)

                    // BFS를 이용해 해당 그림의 크기 계산
                    while(!queue.isEmpty()){
                        int[] current = queue.poll();  // 큐에서 하나씩 꺼내기

                        // 4방향 탐색 (상, 하, 좌, 우)
                        for(int dir = 0; dir < 4; dir++){
                            int nextX = current[0] + directionX[dir];  // 새로운 x 좌표
                            int nextY = current[1] + directionY[dir];  // 새로운 y 좌표

                            // 범위를 벗어나면 탐색하지 않음
                            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;

                            // 이미 방문했거나 그림이 아니라면 건너뛰기
                            if (visited[nextX][nextY] || paper[nextX][nextY] != 1) continue;

                            // 새로운 칸을 방문 처리하고, 큐에 넣어서 계속 탐색
                            visited[nextX][nextY] = true;
                            currentPictureSize++;  // 그림 크기 증가
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }

                    // 현재 그림의 크기와 가장 큰 그림의 크기 비교하여 갱신
                    maxPictureSize = Math.max(maxPictureSize, currentPictureSize);
                }
            }
        }

        // 결과 출력: 그림의 개수와 가장 큰 그림의 크기
        System.out.println(pictureCount);
        System.out.println(maxPictureSize);
    }
}