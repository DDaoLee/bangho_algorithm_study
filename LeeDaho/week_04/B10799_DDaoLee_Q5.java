package LeeDaho.week_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799_DDaoLee_Q5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String stick = br.readLine();
        int piece = 0;
        int add = 0;

        for (int i = 0; i < stick.length(); i++) {
            char c = stick.charAt(i);

            if (c == '(') { 
                stack.push(c);  
                
                if (i != 0 && stick.charAt(i - 1) == '(') add++;

            } else { 
                stack.pop();  

                if (stick.charAt(i - 1) == '(') {  
                    piece += add;  
                } else { 
                    piece++;
                    add--;
                }
            }
        }
        System.out.println(piece);
    }
    
}

//'(' 
// - 전에게 비었을때 그냥 넣기
// - 전이 '(' 일 때 - 다음이 ) 면 더할 조각수 1
// - 전이 ')' 일 떄  그냥 넣기

//')'
// - 전이 비었을때 - 경우 X
// - 전이 ')' 일때  - 합 + 1
// - 전이 '(' 일때  - 합 + 조각수, 조각수 - 1
