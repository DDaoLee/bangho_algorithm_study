import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178_DDaoLee_Q2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 N (세로 크기)과 M (가로 크기) 값을 읽어들임
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 미로를 저장할 2D 배열 선언
        int[][] maze = new int[N][M];

        // 미로 입력 받기 (각 줄을 0과 1로 분리하여 저장)
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");  // 한 줄의 문자열을 0과 1로 분리
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(input[j]);  // 각 칸을 0과 1로 변환하여 미로에 저장
            }
        }
        
        // BFS에 사용할 큐와 거리 배열 선언
        Queue<int[]> queue = new LinkedList<>();
        int[][] shortestPath = new int[N][M];  // 거리 배열 (초기값은 0)
        
        // 시작점 (0, 0)의 거리는 1로 설정
        queue.offer(new int[]{0, 0});
        shortestPath[0][0] = 1;

        // 방향 배열 (우, 하, 좌, 상)
        int[] directionX = new int[]{1, 0, -1, 0};
        int[] directionY = new int[]{0, -1, 0, 1};

        // BFS 시작
        while(!queue.isEmpty()){
            // 현재 큐에서 노드 꺼내기
            int[] current = queue.poll();

            // 현재 노드의 4방향을 탐색
            for (int i = 0; i < 4; i++) {
                // 다음 좌표 계산
                int nextX = current[0] + directionX[i];
                int nextY = current[1] + directionY[i];

                // 범위 밖으로 나가지 않도록 체크
                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;

                // 벽(0)을 만나거나, 이미 방문한 곳(거리값이 0이 아닌 곳)은 넘어가기
                if(maze[nextX][nextY] == 0 || shortestPath[nextX][nextY] != 0) continue;

                // 거리 갱신: 현재 위치의 거리 + 1
                shortestPath[nextX][nextY] = shortestPath[current[0]][current[1]] + 1;

                // 큐에 다음 위치 넣기
                queue.offer(new int[]{nextX, nextY});
            }
        }

        // 목표 지점 (N-1, M-1)의 최단 거리 출력
        System.out.println(shortestPath[N - 1][M - 1]);
    }
}
