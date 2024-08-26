import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 1];
        int[] f = new int[1_000_001];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            f[a[i]]++;
        }

        int[] result = new int[n + 1];
        Arrays.fill(result, -1);

        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!s.isEmpty() && f[a[i]] > f[a[s.peek()]]) {
                result[s.pop()] = a[i];
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
