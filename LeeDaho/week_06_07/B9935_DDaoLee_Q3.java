package LeeDaho.week_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9935_DDaoLee_Q3 {

    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력: 문자열
        String inputData = br.readLine();
        
        // 두 번째 입력: 폭발 문자열
        String bomb = br.readLine();
        
        // 폭발 문자열의 길이
        int bombLength = bomb.length();

        // 문자열을 처리할 Stack 생성
        Stack<Character> stack = new Stack<>();

        // 입력 문자열을 하나씩 순차적으로 처리
        for (int i = 0; i < inputData.length(); i++) {
            // 현재 문자 스택에 추가
            stack.push(inputData.charAt(i));

            // 스택의 크기가 폭발 문자열의 길이 이상이고, 마지막 문자만 일치할 때
            if (stack.size() >= bombLength && inputData.charAt(i) == bomb.charAt(bombLength - 1)) {
                // 폭발 문자열이 일치하는지 확인하는 플래그
                boolean isMatch = true;

                // 폭발 문자열과 스택의 마지막 부분이 일치하는지 확인
                for (int j = 0; j < bombLength; j++) {
                    // 스택의 마지막 부분이 폭발 문자열과 일치하지 않으면
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        isMatch = false;  // 일치하지 않음
                        break;
                    }
                }

                // 폭발 문자열이 일치하면 해당 부분을 스택에서 제거
                if (isMatch) {
                    // 일치한 폭발 문자열을 스택에서 pop()으로 제거
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 스택이 비어 있으면 "FRULA" 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            // 스택에 남은 문자를 이어 붙여서 출력
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
