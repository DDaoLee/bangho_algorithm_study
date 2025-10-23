package LeeDaho.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B3190_DDaoLee_Q5 {

    // 2차원 좌표를 표현하는 Point 클래스
    public static class Point {
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        // Point 비교를 위해 equals, hashCode 오버라이드
        // 해당 메소드를 오버라이드 하지 않으면 Snake의 isSelfCollision 메소드 내 contains()가 작동하지않음
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }

    // Snake 클래스는 뱀의 상태(몸통, 방향)과 동작(이동, 충돌 등)을 관리
    public static class Snake {
        private Deque<Point> body = new LinkedList<>();  // 뱀의 몸통 좌표 (앞: 꼬리, 뒤: 머리)
        int direction = 0;                               // 현재 방향 (우, 하, 좌, 상 순)
        int[] dx = {1, 0, -1, 0};                        // x축 이동 벡터
        int[] dy = {0, 1, 0, -1};                        // y축 이동 벡터

        public Snake(){
            body.add(new Point(0, 0)); // 뱀의 시작 위치 (0,0)
        }

        public Point getHead(){
            return body.peekLast(); // 현재 머리 위치 반환
        }

        public Point getNextHead() {
            Point head = getHead();
            return new Point(head.x + dx[direction], head.y + dy[direction]);
        }

        public Deque<Point> getBody(){
            return this.body;
        }

        // 벽 충돌 여부 확인
        public boolean isWallCollision(Point nextHead, int[][] board){
            return nextHead.x < 0 || nextHead.x >= board[0].length
                || nextHead.y < 0 || nextHead.y >= board.length;
        }

        // 몸통 충돌 여부 확인
        public boolean isSelfCollision(Point nextHead){
            return this.body.contains(nextHead);
        }

        // 사과 없을 때: 머리 한 칸 이동, 꼬리 제거
        public void move(Point nextHead){
            body.addLast(nextHead);
            body.pollFirst();
        }

        // 사과 있을 때: 머리만 이동, 꼬리 유지
        public void grow(Point nextHead){
            body.addLast(nextHead);
        }

        // 방향 전환
        public void turn(char c) {
            if (c == 'L') {
                direction = (direction + 3) % 4; // 왼쪽 회전
            } else if (c == 'D') {
                direction = (direction + 1) % 4; // 오른쪽 회전
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 보드 크기 입력
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        // 사과 위치 입력
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            board[y][x] = 1; // 사과 위치 표시
        }

        // 방향 전환 정보 입력
        int L = Integer.parseInt(br.readLine());
        int[] times = new int[L];     // 시간 배열
        char[] turns = new char[L];   // 방향 배열 (L or D)

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            turns[i] = st.nextToken().charAt(0);
        }

        // 게임 시작
        Snake snake = new Snake();
        int gameTime = 0;
        int turnCommndIdx = 0;

        while(true){
            gameTime++;

            // 다음 머리 위치 계산
            Point nextHead = snake.getNextHead();

            // 벽 또는 자기자신 충돌 시 게임 종료
            if (snake.isWallCollision(nextHead, board)) break;
            if (snake.isSelfCollision(nextHead)) break;

            // 사과가 있는 경우 grow, 없으면 move
            if(board[nextHead.y][nextHead.x] == 1){
                snake.grow(nextHead);
                board[nextHead.y][nextHead.x] = 0; // 사과 제거
            } else {
                snake.move(nextHead);
            }

            // 방향 전환 시간 도달 시 회전
            if(turnCommndIdx < L && gameTime == times[turnCommndIdx]){
                snake.turn(turns[turnCommndIdx]);
                turnCommndIdx++;
            }
        }

        // 게임 종료 시간 출력
        System.out.println(gameTime);
    }
}
