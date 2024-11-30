import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int q = Integer.parseInt(br.readLine());
        
        Stack<String> s = new Stack<>();
        s.push("");
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            
            if (op == 1) {
                String w = st.nextToken();
                s.push(s.peek() + w);
            } else if (op == 2) {
                int k = Integer.parseInt(st.nextToken());
                int len = s.peek().length();
                s.push(s.peek().substring(0, len - k));
            } else if (op == 3) {
                int k = Integer.parseInt(st.nextToken());
                System.out.println(s.peek().charAt(k - 1));
            } else {
                s.pop();
            }
        }
    }
}
