package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_DDaoLee_Q0_LinkedList {
    public static class MyStack {
        Node top;
        int size;

        public class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public void push(int x) {
            Node newNode = new Node(x);
            newNode.next = top;
            top = newNode;
            size++;
        }

        public int pop() {
            if (empty() == 1) return -1;
            int value = top.data;
            top = top.next;
            size--;
            return value;
        }

        public int size() {
            return size;
        }

        public int empty() {
            return size == 0 ? 1 : 0;
        }

        public int top() {
            return empty() == 1 ? -1 : top.data;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        MyStack myStack = new MyStack();

        StringTokenizer st;
        String cmd;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    myStack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(myStack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(myStack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(myStack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(myStack.top()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
