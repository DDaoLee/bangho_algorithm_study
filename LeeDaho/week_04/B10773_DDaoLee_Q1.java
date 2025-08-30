package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10773_DDaoLee_Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 스택을 생성
        Stack<Integer> stack = new Stack<>();

        // 입력받을 수 K를 읽음
        int K = Integer.parseInt(br.readLine());
        int data;

        // K번 만큼 데이터를 처리
        for (int i = 0; i < K; i++) {
            // 각 입력값을 읽음
            data =  Integer.parseInt(br.readLine());
            
            // 데이터가 0이면 스택에서 가장 최근에 들어온 값을 pop
            if(data == 0) stack.pop();
            // 그 외의 값이면 스택에 해당 값을 push
            else stack.push(data);
        }

        // 스택에 남은 값들의 합을 구하기 위한 변수
        int sum = 0;
        int size = stack.size(); // 현재 스택의 크기 저장
        
        // 스택의 모든 값을 pop 하면서 합산
        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }

        // 최종 합을 출력
        System.out.println(sum);
    }
}
