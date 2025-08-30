package LeeDaho.week_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

// ListIteratorfkd StringBuilder를 둘 다 사용하지 않으면 시간초과, 실제로 겪은 일 *^^*
public class B1406_DDaoLee_Q4 {

    // 입력에 따라 커서(ListIterator<Character>)와 문자열(LinkedList<Character>)을 조작하는 메서드
    public static void operateCommand( ListIterator<Character> iter, StringTokenizer st){
        char cmd = st.nextToken().charAt(0); // 명령어 첫 글자 추출

        switch (cmd) {
            case 'L': // 커서를 왼쪽으로 이동
                if(iter.hasPrevious()) iter.previous();
                break;

            case 'D': // 커서를 오른쪽으로 이동
                if(iter.hasNext()) iter.next();
                break;

            case 'B': // 커서 왼쪽 문자 삭제
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();    
                }
                break;

            case 'P': // 커서 왼쪽에 문자 삽입
                char ch = st.nextToken().charAt(0);
                iter.add(ch);
                break;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 초기 문자열 입력
        
        // LinkedList<Character>로 에디터 내용 초기화
        LinkedList<Character> editor = new LinkedList<Character>();
        for(char c : input.toCharArray()) editor.add(c);

        int numberOfCmd = Integer.parseInt(br.readLine()); // 명령어 수

        // 커서 역할: ListIterator 사용
        // ListIterator를 사용하면 LinkedList에서 index 기반 add/remove를 쓰지 않고 O(1)로 처리 가능
        ListIterator<Character> cursor = editor.listIterator(editor.size());

        StringTokenizer st; 
        while(numberOfCmd-- > 0){
            st = new StringTokenizer(br.readLine());
            operateCommand(cursor, st); // 명령어 처리
        }

        // 결과 출력
        // StringBuilder를 사용하지 않고 System.out.print(editor.get(i))처럼 하면
        // LinkedList의 get(i)는 O(n) 반복 수행되어 n이 크면 시간초과 발생
        StringBuilder sb = new StringBuilder();
        for (char c : editor) sb.append(c);
        System.out.println(sb);
    }
    
}
