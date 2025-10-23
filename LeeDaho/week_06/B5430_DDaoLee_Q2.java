package LeeDaho.week_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B5430_DDaoLee_Q2 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 T
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스의 결과를 저장할 StringBuilder 배열
        StringBuilder[] results = new StringBuilder[T];

        // 테스트 케이스 T번 만큼 반복
        for (int i = 0; i < T; i++) {
            // 각 테스트 케이스에서 사용할 명령어 문자열
            String commands = br.readLine();
            
            // 배열의 크기 n
            int n = Integer.parseInt(br.readLine());
            
            // 배열의 원소들 (형식: [1,2,3])
            String input = br.readLine();

            // 덱(Deque)을 사용하여 입력된 배열을 처리할 준비
            Deque<Integer> deque = new ArrayDeque<>();

            // 입력된 배열에서 양쪽 대괄호([])를 제거하고 처리
            input = input.substring(1, input.length() - 1); 
            
            // 배열 크기가 0보다 크면, 쉼표로 구분된 숫자들을 덱에 넣기
            if (n > 0) {
                // 쉼표로 구분된 숫자들 파싱하여 덱에 넣기
                String[] tokens = input.split(",");
                for (String token : tokens) {
                    deque.offer(Integer.parseInt(token.trim())); // 트림하여 숫자로 변환 후 덱에 추가
                }
            }

            // 덱을 뒤집을지 여부를 추적하는 변수 (R 명령어로 뒤집을 수 있음)
            boolean isReversed = false;
            
            // 에러가 발생했는지 여부를 추적하는 변수 (D 명령어에서 덱이 비어있을 때)
            boolean isError = false;

            // 명령어를 하나씩 처리
            for (char command : commands.toCharArray()) {
                if (command == 'R') {
                    // R 명령어: 덱을 뒤집는다. isReversed 플래그를 토글
                    isReversed = !isReversed;
                } else if (command == 'D') {
                    // D 명령어: 덱에서 하나의 원소를 제거
                    if (deque.isEmpty()) {
                        // 덱이 비어있을 경우 "error" 처리
                        isError = true;
                        break;
                    }
                    // 덱이 뒤집어졌는지 여부에 따라 앞 또는 뒤에서 제거
                    if (isReversed) {
                        deque.pollLast(); // 뒤에서 하나 제거
                    } else {
                        deque.pollFirst(); // 앞에서 하나 제거
                    }
                }
            }

            // 결과를 저장할 StringBuilder
            StringBuilder sb = new StringBuilder();
            if (isError) {
                // 에러가 발생하면 "error" 출력
                sb.append("error");
            } else {
                // 에러가 발생하지 않으면 덱을 출력 형식에 맞게 변환
                sb.append("[");
                
                // 덱에서 값을 하나씩 꺼내어 출력, 덱이 뒤집어졌으면 뒤에서부터 출력
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    // 값 뒤에 쉼표를 붙이되, 마지막 값 뒤에는 붙이지 않음
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
            }

            // 결과를 배열에 저장
            results[i] = sb;
        }

        // 모든 테스트 케이스의 결과 출력
        for (StringBuilder sb : results) {
            System.out.println(sb);
        }
    }
}
