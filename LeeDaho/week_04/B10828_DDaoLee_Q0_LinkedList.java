package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_DDaoLee_Q0_LinkedList {
    
    // 스택을 LinkedList 방식으로 구현하는 클래스
    public static class MyStack {
        
        // 스택의 top을 나타내는 노드
        Node top;
        // 스택의 크기
        int size;

        // 노드 클래스: 데이터와 다음 노드를 연결
        public class Node {
            int data;
            Node next;

            // 생성자: 노드 데이터와 다음 노드를 초기화
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // push 명령: 스택에 값 추가
        public void push(int x) {
            Node newNode = new Node(x); // 새로운 노드를 생성
            newNode.next = top; // 새 노드의 next를 기존 top에 연결
            top = newNode; // top을 새 노드로 업데이트
            size++; // 크기 증가
        }

        // pop 명령: 스택에서 값 꺼내기
        public int pop() {
            if (empty() == 1) return -1; // 스택이 비어 있으면 -1 반환
            int value = top.data; // top 값 저장
            top = top.next; // top을 다음 노드로 이동
            size--; // 크기 감소
            return value; // 꺼낸 값 반환
        }

        // size 명령: 스택의 크기 반환
        public int size() {
            return size; // 현재 스택의 크기 반환
        }

        // empty 명령: 스택이 비어 있는지 확인
        public int empty() {
            return size == 0 ? 1 : 0; // 스택이 비었으면 1, 아니면 0 반환
        }

        // top 명령: 스택의 top 값 반환
        public int top() {
            return empty() == 1 ? -1 : top.data; // 스택이 비었으면 -1, 아니면 top 데이터 반환
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 명령어의 개수 N을 입력
        int N = Integer.parseInt(br.readLine());
        // 커스텀 스택 객체 생성
        MyStack myStack = new MyStack();

        // 명령어 처리
        StringTokenizer st;
        String cmd;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken(); // 명령어 추출

            // 각 명령어에 따라 스택에 대한 작업 수행
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

        // 결과 출력
        System.out.print(sb);
    }
}
