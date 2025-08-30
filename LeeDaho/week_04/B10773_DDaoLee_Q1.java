package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10773_DDaoLee_Q1{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());
        int data;

        for (int i = 0; i < K; i++) {
            data =  Integer.parseInt(br.readLine());
            if(data == 0) stack.pop();
            else stack.push(data);
        }

        int sum = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }
        System.out.println(sum);

    }
}