package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_DDaoLee_Q0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 명령어의 개수 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // stack 배열을 10000으로 생성하고, 인덱스를 -1로 초기화
        int[] stack = new int[10000];
        int index = -1;

        // N번 만큼 명령어를 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 명령어를 첫 번째 토큰으로 받음
            String cmd = st.nextToken();

            // 각 명령어에 맞는 작업을 처리
            switch (cmd) {
                // "push" 명령: 스택에 값을 추가
                case "push":
                    // 스택의 top을 한 칸 증가시키고 값을 넣음
                    stack[++index] = Integer.parseInt(st.nextToken());
                    break;

                // "pop" 명령: 스택에서 값을 꺼내고 출력
                case "pop":
                    // 스택이 비어있으면 -1을 출력, 아니면 스택의 top 값을 꺼내고 출력
                    System.out.println(index == -1 ? -1 : stack[index--]);
                    break;

                // "size" 명령: 스택의 크기를 출력
                case "size":
                    // 스택에 들어있는 요소의 수는 index + 1
                    System.out.println(index + 1);
                    break;

                // "empty" 명령: 스택이 비었는지 확인
                case "empty":
                    // 스택이 비었으면 1, 아니면 0 출력
                    System.out.println(index == -1 ? 1 : 0);
                    break;

                // "top" 명령: 스택의 top 값을 출력
                case "top":
                    // 스택이 비었으면 -1, 아니면 스택의 top 값을 출력
                    System.out.println(index == -1 ? -1 : stack[index]);
                    break;
            }
        }   
    }
}
