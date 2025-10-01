package LeeDaho.week_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2812_DDaoLee_Q5 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader와 StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 숫자의 길이, K: 제거해야 할 숫자의 개수
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 숫자 문자열 입력받기
        String number = br.readLine();
        
        // 스택을 이용하여 최대 숫자 만들기
        Stack<Character> stack = new Stack<>();

        // 숫자 문자열을 왼쪽부터 한 자리씩 처리
        for (int i = 0; i < N; i++) {
            // 현재 처리할 숫자
            char currentData = number.charAt(i);

            // 스택에 있는 숫자들이 currentData보다 작고, 제거할 수 있는 숫자(K)가 남아있으면
            // 작은 숫자를 스택에서 빼고, K를 감소시킨다.
            while (!stack.isEmpty() && stack.peek() < currentData && K > 0) {
                stack.pop();  // 작은 숫자를 제거
                K--;          // 제거한 만큼 K 감소
            }

            // 현재 숫자는 스택에 넣기
            stack.push(currentData);
        }

        // 아직 제거할 숫자(K)가 남아 있다면, 스택에서 K번만큼 더 빼기
        while (K > 0) {
            stack.pop();
            K--;
        }

        // 스택에 남아 있는 숫자들을 문자열로 변환하여 출력
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);  // 스택에 저장된 숫자들을 순서대로 추가
        }
        System.out.println(sb);  // 결과 출력
    }
}
