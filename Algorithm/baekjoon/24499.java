import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[n];
        for (int i = 0; i < k; i++) {
            sum[0] += a[i];
        }
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] - a[i - 1] + a[(i + k - 1) % n];
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, sum[i]);
        }
        System.out.println(answer);
    }
}
