import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] mn = new int[n + 1];
        mn[0] = 1_000_000_001;
        for (int i = 1; i <= n; i++) {
            mn[i] = Math.min(mn[i - 1], a[i]);
        }

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i - 1];
            result[i] = Math.max(result[i], a[i] - mn[i]);
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            answer.append(result[i]).append(" ");
        }
        System.out.println(answer);
    }
}
