import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String infix = br.readLine();

        Stack<Character> s = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (Character c : infix.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                postfix.append(c);
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    postfix.append(s.pop());
                }
                s.pop();
            } else if (c == '*' || c == '/') {
                while (!s.isEmpty() && s.peek() != '(' && (s.peek() == '*' || s.peek() == '/')) {
                    postfix.append(s.pop());
                }
                s.push(c);
            } else if (c == '+' || c == '-') {
                while (!s.isEmpty() && s.peek() != '(') {
                    postfix.append(s.pop());
                }
                s.push(c);
            }
        }
        while (!s.isEmpty()) {
            postfix.append(s.pop());
        }
        System.out.println(postfix);
    }
}
