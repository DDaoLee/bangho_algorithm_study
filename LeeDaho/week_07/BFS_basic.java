import java.util.LinkedList;
import java.util.Queue;

public class BFS_basic {
    static int[][] board = {
        {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 1, 0, 0, 0, 0, 0},
        {1, 1, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    static boolean[][] vis = new boolean[502][502];
    static int n = 7, m = 10;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Queue<int[]> queue = new LinkedList<>();
        vis[0][0] = true;
        queue.offer(new int[]{0, 0}); // 큐에 시작점 (0, 0)을 삽입
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); // 큐에서 현재 좌표를 꺼냄
            System.out.print("(" + cur[0] + ", " + cur[1] + ") -> ");
            
            for (int dir = 0; dir < 4; dir++) { // 상하좌우 네 방향 탐색
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                
                // 범위 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                // 방문 여부 및 파란 칸 체크
                if (vis[nx][ny] || board[nx][ny] != 1) continue;
                
                vis[nx][ny] = true; // (nx, ny) 방문 표시
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}