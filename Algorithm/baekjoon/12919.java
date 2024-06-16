import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        int answer = 0;
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        visited.add(t);
        q.add(t);
        while (!q.isEmpty()) {
            String cur = q.poll();

            if (Objects.equals(cur, s)) {
                answer = 1;
                break;
            }

            if (cur.length() <= s.length()) {
                continue;
            }
            if (cur.charAt(cur.length() - 1) == 'A') {
                StringBuilder nxt = new StringBuilder(cur).deleteCharAt(cur.length() - 1);
                if (visited.add(nxt.toString())) {
                    q.add(nxt.toString());
                }
            }
            if (cur.charAt(0) == 'B') {
                StringBuilder nxt = new StringBuilder(cur).reverse().deleteCharAt(cur.length() - 1);
                if (visited.add(nxt.toString())) {
                    q.add(nxt.toString());
                }
            }
        }
        System.out.println(answer);
    }
}
