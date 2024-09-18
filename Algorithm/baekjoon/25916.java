import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1, j = i, rst = 0; j <= n; j++) {
            rst += a[j];
            while (i <= j && rst > m) {
                rst -= a[i++];
            }
            answer = Math.max(answer, rst);
        }
        System.out.println(answer);
    }
}
