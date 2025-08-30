package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B3986_DDaoLee_Q2 {

    public static void main(String[] args) throws IOException{
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스의 개수 N을 입력
        int N = Integer.parseInt(br.readLine());

        String text;
        int cnt = 0; // 올바른 괄호 문자열의 개수
        
        // N번 만큼 테스트 케이스를 처리
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>(); // 스택을 이용하여 괄호 문자열 처리
            text = br.readLine(); // 테스트 문자열 입력

            // 문자열의 각 문자 처리
            for (int j = 0; j < text.length(); j++) {
                char c = text.charAt(j);

                // 스택에 문자가 있고, 스택의 top과 현재 문자가 같으면 pop (짝이 맞는 경우)
                if(!stack.empty() && stack.peek() == c) {
                    stack.pop();
                }
                // 아니면 현재 문자를 스택에 푸시 (짝이 맞지 않거나 스택이 비었을 경우)
                else {
                    stack.push(c);
                }
            }

            // 문자열을 끝까지 처리한 후 스택이 비어 있으면 올바른 문자열
            if(stack.empty()) cnt++; 
        }

        // 올바른 문자열의 개수를 출력
        System.out.println(cnt);
    }
}
