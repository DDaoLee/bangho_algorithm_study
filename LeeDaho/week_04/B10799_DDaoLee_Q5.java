package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799_DDaoLee_Q5 {
    public static void main(String[] args) throws IOException{
        // 입력을 받기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 스택 생성
        Stack<Character> stack = new Stack<>();
        // 레이저와 스틱을 나타내는 문자열 입력
        String stick = br.readLine();
        
        // 총 조각 수
        int piece = 0;
        // 추가된 조각 수 (레이저가 자르는 부분에서 사용)
        int add = 0;

        // 문자열의 각 문자에 대해 반복
        for (int i = 0; i < stick.length(); i++) {
            char c = stick.charAt(i);

            // '(' 일 경우
            if (c == '(') {
                // 스택에 '(' 추가
                stack.push(c);  
                
                // 현재 문자가 '(' 일 때, 이전 '('는 쇠막대기 추가를 의미
                if (i != 0 && stick.charAt(i - 1) == '(') {
                    add++;  // 추가될 조각 수를 증가시킴
                }
            } else {  // ')' 일 경우
                // 반드시 짝이 맞으므로 스택에서 pop
                stack.pop();  

                // 만약 직전에 '('가 왔다면, 레이저이므로 추가될 조각 수만큼 추가
                if (stick.charAt(i - 1) == '(') {
                    piece += add;  // 추가될 조각 수만큼 더함
                } else {  // 현재 문자가 ')'일 때, 이전 문자가 ')'라면 스틱이 끝나는 경우이므로 남은 스틱을 더함(+ 1)
                    piece++;  // 하나의 스틱을 끝낸 것이므로 1 추가
                    add--;  // 레이저로 잘라낼 부분이 줄었으므로 추가될 조각 수 감소
                }
            }
        }
        
        // 최종적으로 잘린 조각의 수 출력
        System.out.println(piece);
    }
}