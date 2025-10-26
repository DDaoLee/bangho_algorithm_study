package LeeDaho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prac {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] inputA = st.nextToken().split("");
            String[] inputB = st.nextToken().split("");
            Arrays.sort(inputA);
            Arrays.sort(inputB);

            if(Arrays.equals(inputA, inputB)) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
}

