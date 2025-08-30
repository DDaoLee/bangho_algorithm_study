package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828_DDaoLee_Q0_Stack {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 명령어의 개수 N을 입력
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        
        StringTokenizer st;
        String cmd;
        
        // 명령어를 N번 만큼 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 첫 번째 토큰은 명령어
            cmd = st.nextToken();

            // 명령어에 따라 작업을 분기
            switch (cmd) {
                // "push" 명령: 스택에 값을 추가
                case "push":
                    // 입력 받은 값을 스택에 추가
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                // "pop" 명령: 스택에서 값을 꺼내고 출력
                case "pop":
                    // 스택이 비어있지 않으면 pop, 비어있으면 -1 출력
                    if(!stack.empty()) sb.append(stack.pop()).append("\n");
                    else sb.append(-1).append("\n");
                    break;

                // "size" 명령: 스택의 크기를 출력
                case "size":
                    // 스택에 들어있는 요소의 개수 출력
                    sb.append(stack.size()).append("\n");
                    break;

                // "empty" 명령: 스택이 비어있는지 확인
                case "empty":
                    // 스택이 비어있지 않으면 0, 비어있으면 1 출력
                    if(!stack.empty()) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;

                // "top" 명령: 스택의 top 값을 출력
                case "top":
                    // 스택이 비어있지 않으면 top 값을 출력, 비어있으면 -1 출력
                    if(!stack.empty()) sb.append(stack.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }

        // 최종 출력 결과를 한 번에 출력
        System.out.println(sb);
    }
}
