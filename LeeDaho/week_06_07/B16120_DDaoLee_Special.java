package LeeDaho.week_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B16120_DDaoLee_Special {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 문자열
        String input = br.readLine();

        // PPAP 문자열을 찾기 위한 Stack 생성
        Stack<Character> stack = new Stack<>();

        // 입력 문자열을 한 문자씩 처리
        for (int i = 0; i < input.length(); i++) {
            // 현재 문자를 스택에 추가
            stack.push(input.charAt(i));

            // 스택 크기가 "PPAP"의 길이 이상이고, 스택의 마지막 문자가 'P'일 때
            if (stack.size() >= "PPAP".length() && stack.peek() == 'P') {
                // "PPAP" 패턴이 일치하는지 여부를 확인하는 변수
                boolean isPPAP = true;

                // "PPAP" 문자열이 스택의 마지막 부분과 일치하는지 확인
                for (int j = 0; j < "PPAP".length(); j++) {
                    if ("PPAP".charAt(j) != stack.get(stack.size() - "PPAP".length() + j)) {
                        // 만약 일치하지 않으면, isPPAP을 false로 설정하고 루프 종료
                        isPPAP = false;
                        break;
                    }
                }

                // "PPAP" 패턴이 일치하면 해당 부분을 스택에서 제거
                if (isPPAP) {
                    // "PPAP" 패턴에서 'P'만 남기고 나머지 'P', 'P', 'A'를 pop()
                    for (int j = 0; j < "PPAP".length() - 1; j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 스택에 'P' 하나만 남아있으면 "PPAP" 출력, 그렇지 않으면 "NP" 출력
        if (stack.size() == 1 && stack.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
