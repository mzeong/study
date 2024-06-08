import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String e = br.readLine();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));

            if (st.size() >= e.length() && st.peek() == e.charAt(e.length() - 1)) {
                int j = 0;
                while (j < e.length()) {
                    if (st.get(st.size() - 1 - j) != e.charAt(e.length() - 1 - j)) {
                        break;
                    }
                    j++;
                }
                if (j == e.length()) {
                    while (j-- > 0) {
                        st.pop();
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (Character c : st) {
            answer.append(c);
        }
        System.out.println(answer.length() > 0 ? answer : "FRULA");
    }
}
