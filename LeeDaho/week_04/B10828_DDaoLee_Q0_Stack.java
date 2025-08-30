package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828_DDaoLee_Q0_Stack {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        StringTokenizer st;
        String cmd;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!stack.empty()) sb.append(stack.pop()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(!stack.empty()) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                case "top":
                    if(!stack.empty()) sb.append(stack.peek()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
    
}
