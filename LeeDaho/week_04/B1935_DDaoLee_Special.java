package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class B1935_DDaoLee_Special {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 피연산자의 개수 N을 입력받음
        int N = Integer.parseInt(br.readLine());
        
        // 피연산자 값을 저장할 배열 생성
        double[] value = new double[N];
        
        // 후위 표기법 표현식 입력받기
        String expression = br.readLine();

        // 각 변수(A, B, C, ...)에 해당하는 피연산자 값을 입력받음
        for (int i = 0; i < value.length; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        // 스택을 이용하여 연산을 처리
        Stack<Double> stack = new Stack<>();
        
        // 연산자 목록을 Set에 저장
        Set<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        // 후위 표기법에서 각 문자 처리
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 만약 문자가 연산자가 아니라면, 해당 변수(A, B, C, ...)의 값을 스택에 푸시
            if(!operators.contains(c)) {
                stack.push(value[c - 'A']);
            } 
            // 연산자라면, 스택에서 두 피연산자를 꺼내서 계산하고 결과를 다시 스택에 푸시
            // 이때, 스택은 뒤의 문자부터 pop되므로 두번째 피연산자를 우선적으로 생성
            else {
                double num2 = stack.pop(); // 두 번째 피연산자
                double num1 = stack.pop(); // 첫 번째 피연산자
                switch (c) {
                    case '+':
                        stack.push(num1 + num2); // 더하기
                        break;
                    case '-':
                        stack.push(num1 - num2); // 빼기
                        break;
                    case '*':
                        stack.push(num1 * num2); // 곱하기
                        break;
                    case '/':
                        stack.push(num1 / num2); // 나누기
                        break;
                }
            }
        }

        // 최종 결과를 소수점 둘째 자리까지 출력
        System.out.printf("%.2f\n", stack.pop());
    }
}
