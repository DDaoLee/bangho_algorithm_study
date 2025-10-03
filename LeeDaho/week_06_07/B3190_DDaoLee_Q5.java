package LeeDaho.week_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B3190_DDaoLee_Q5 {

    public static class Point {
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
            
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

    public static class Snake {
        private Deque<Point> body = new LinkedList<>();
        int direction = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        public Snake(){
            body.add(new Point(0, 0));
        }

        public Point getHead(){
            return body.peekLast();
        }

        public Point getNextHead() {
            Point head = getHead();
            return new Point(head.x + dx[direction], head.y + dy[direction]);
        }

        public Deque<Point> getBody(){
            return this.body;
        }

        public boolean isWallCollision(Point nextHead, int[][] board){
            if (nextHead.x < 0 || nextHead.x >= board[0].length || nextHead.y < 0 || nextHead.y >= board.length) {
                return true;
            }
            return false;
        }

        public boolean isSelfCollision(Point nextHead){
            if(this.getBody().contains(nextHead)){
                return true;
            }
            return false;
        }

        public void move(Point nextHead){
            body.addLast(nextHead);
            body.pollFirst();
        }

        public void grow(Point nextHead){
            body.addLast(nextHead);
        }

        public void turn(char c) {
            if (c == 'L') {
                direction = (direction + 3) % 4;
            } else if (c == 'D') {
                direction = (direction + 1) % 4;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1; 
        }

        int L = Integer.parseInt(br.readLine());
        int[] times = new int[L];
        char[] turns = new char[L];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            turns[i] = st.nextToken().charAt(0);
        }
        
        Snake snake = new Snake();
        int gameTime = 0;
        int turnCommndIdx = 0;

        while(true){
            gameTime++;
            Point nextHead = snake.getNextHead();

            if (snake.isWallCollision(nextHead, board)) {
                break;
            }

            if(snake.isSelfCollision(nextHead)) {
                break;
            }

            if(board[nextHead.y][nextHead.x] == 1){
                snake.grow(nextHead);
                board[nextHead.y][nextHead.x] = 0; 
            } else {
                snake.move(nextHead);
            }

            if(turnCommndIdx < L && gameTime == times[turnCommndIdx]){
                snake.turn(turns[turnCommndIdx]);
                turnCommndIdx++;
            }
        }

        System.out.println(gameTime);

    }
} 
