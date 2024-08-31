import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        int[] result = new int[n + 1];
        for (int i = n; i > 0; i--) {
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                result[s.pop()] = i;
            }
            s.push(i);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            answer.append(result[i]).append(" ");
        }
        System.out.println(answer);
    }
}
