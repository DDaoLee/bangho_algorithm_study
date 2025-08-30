package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_DDaoLee_Q0_Array {

    // 배열을 이용해 스택을 구현하는 클래스
    public static class MyStack {
        
        // 배열의 크기와 스택의 top을 나타내는 인덱스
        int index;
        int[] top;

        // 생성자: 주어진 크기로 스택을 초기화
        public MyStack(int size) {
            top = new int[size]; // 크기가 size인 배열을 할당
            index = -1; // 스택이 비어있으므로 인덱스를 -1로 초기화
        }

        // push 명령: 스택에 데이터를 추가
        public void push(int data) {
            top[++index] = data; // index를 증가시키고, 배열에 데이터를 넣음
        }

        // pop 명령: 스택에서 데이터를 꺼내고 반환
        public int pop() {
            if (index == -1) return -1; // 스택이 비어있으면 -1 반환
            return top[index--]; // top 데이터를 반환하고, 인덱스를 감소
        }

        // size 명령: 스택에 들어있는 데이터의 개수 반환
        public int size() {
            return index + 1; // index는 마지막 데이터의 인덱스이므로, 크기는 index + 1
        }

        // empty 명령: 스택이 비어있는지 확인
        public int empty() {
            return index == -1 ? 1 : 0; // 비어있으면 1, 아니면 0 반환
        }

        // top 명령: 스택의 top 데이터를 반환
        public int top() {
            if (index == -1) return -1; // 스택이 비어있으면 -1 반환
            return top[index]; // top 데이터를 반환
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령어의 개수 N을 입력
        int N = Integer.parseInt(br.readLine());
        // 크기가 10000인 스택 생성
        MyStack myStack = new MyStack(10000);

        // 명령어 처리
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken(); // 첫 번째 토큰은 명령어

            // 각 명령어에 맞는 작업을 실행
            switch (cmd) {
                case "push":
                    myStack.push(Integer.parseInt(st.nextToken())); // "push" 명령 처리
                    break;
                case "pop":
                    sb.append(myStack.pop()).append("\n"); // "pop" 명령 처리
                    break;
                case "size":
                    sb.append(myStack.size()).append("\n"); // "size" 명령 처리
                    break;
                case "empty":
                    sb.append(myStack.empty()).append("\n"); // "empty" 명령 처리
                    break;
                case "top":
                    sb.append(myStack.top()).append("\n"); // "top" 명령 처리
                    break;
            }
        }

        // 최종 출력 결과를 한 번에 출력
        System.out.print(sb);
    }
}
