package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012_DDaoLee_Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스의 개수 T를 입력
        int T = Integer.parseInt(br.readLine());

        String data;
        // T번 만큼 테스트 케이스를 처리
        for (int i = 0; i < T; i++) {
            // 괄호 문자열을 처리하기 위한 Stack 생성
            Stack<Character> stack = new Stack<>();
            data = br.readLine(); // 괄호 문자열 입력

            // 문자열의 각 문자 처리
            for (int j = 0; j < data.length(); j++) {
                char c = data.charAt(j);

                // 여는 괄호 '('일 경우 스택에 푸시
                if (c == '(') {
                    stack.push(c);
                }
                // 닫는 괄호 ')'일 경우
                else {
                    // 스택이 비어 있으면 짝이 맞지 않으므로 더 이상 진행할 필요 없음
                    if (stack.isEmpty()) {
                        stack.push(c); // 스택에 닫는 괄호가 남아있도록 ')'를 푸쉬
                        break; // 더 이상 진행하지 않고 다음 테스트 케이스로 이동
                    }
                    // 짝이 맞으면 스택에서 pop
                    stack.pop();
                }
            }

            // 스택이 비어 있으면 괄호가 모두 짝이 맞는 것이므로 "YES"
            // 스택에 괄호가 남아 있으면 "NO"
            if(stack.empty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        // 모든 결과를 한 번에 출력
        System.out.println(sb);
    }
}
