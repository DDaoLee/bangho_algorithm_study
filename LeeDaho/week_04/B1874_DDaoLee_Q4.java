package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874_DDaoLee_Q4 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 스택에 들어갈 숫자의 개수를 입력
        int n = Integer.parseInt(br.readLine());
        
        // arr 배열에 목표 숫자들을 입력받음
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 목표로 만들어야 하는 수열
        }
        
        int idx = 0; // 현재 비교해야 할 목표 숫자의 인덱스

        // 1부터 n까지 숫자를 스택에 차례대로 넣음
        for (int i = 1; i <= n; i++) {
            stack.push(i); // 현재 숫자를 스택에 푸시
            sb.append("+").append("\n"); // "+" 연산 기록

            // 스택의 top 값과 목표 배열 arr[idx]가 같으면 스택에서 pop하고, idx를 증가
            while(!stack.isEmpty() && stack.peek() == arr[idx]){
                stack.pop(); // 스택에서 pop
                sb.append("-").append("\n"); // "-" 연산 기록
                idx++; // 다음 목표 숫자로 이동
            }
        }

        // 목표 배열의 모든 값이 처리되었으면, 출력
        if(idx == n) System.out.println(sb); // 목표 수열이 완성되었으면 연산 결과 출력
        else System.out.println("NO"); // 목표 수열이 불가능하면 "NO" 출력
    }
}
