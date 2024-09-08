import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] lengths = new int[w];
        for (int i = 0; i < w; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        int answer = 0;
        for (int i = 0; i < w; i++) {
            if (s.empty() || lengths[i] < lengths[s.get(0)]) {
                s.push(i);
            } else {
                while (!s.empty()) {
                    answer += lengths[s.get(0)] - lengths[s.pop()];
                }
                s.push(i);
            }
        }
        int tmp = s.pop();
        while (!s.empty()) {
            /*
            3 6
            5 4 1 3 1 2
            answer: 3
             */
            if (lengths[tmp] > lengths[s.peek()]) {
                answer += lengths[tmp] - lengths[s.pop()];
            } else {
                tmp = s.pop();
            }
        }
        System.out.println(answer);
    }
}
