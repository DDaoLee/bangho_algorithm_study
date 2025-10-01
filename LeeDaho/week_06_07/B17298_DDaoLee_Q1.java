package LeeDaho.week_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298_DDaoLee_Q1 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 첫 번째 입력: 수열의 길이 N
        int N = Integer.parseInt(br.readLine());
        
        // 두 번째 입력: 수열의 원소들
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열을 저장할 배열 numbers
        int[] numbers = new int[N];
        
        // 수열의 원소들을 배열 numbers에 저장
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 스택을 사용하여 처리
        Stack<Integer> stack = new Stack<>();
        
        // 결과를 저장할 배열 ans
        int[] ans = new int[N];

        // 뒤에서부터 수열을 탐색 (N-1에서 0까지)
        for (int i = N - 1; i >= 0; i--) {
            // 스택이 비어 있지 않고, 현재 숫자가 스택의 top 값보다 크거나 같으면
            while (!stack.empty() && numbers[i] >= stack.peek()) {
                // 스택에서 pop하여 현재 숫자보다 작은 값만 남도록 함
                stack.pop();
            }

            // 스택이 비어 있으면, 다음 큰 숫자가 없다는 의미로 -1을 저장
            if (stack.empty()) {
                ans[i] = -1;
            } else {
                // 스택의 top 값이 현재 수보다 큰 숫자이므로, 그것을 기록
                ans[i] = stack.peek();
            }

            // 현재 숫자를 스택에 push (다음에 이 숫자를 기준으로 다음 큰 숫자를 찾기 위해)
            stack.push(numbers[i]);
        }

        // 결과 배열 ans를 StringBuilder를 이용해 출력 형식에 맞게 변환
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }
        
        // 최종적으로 결과 출력
        System.out.println(sb);
    }
}
