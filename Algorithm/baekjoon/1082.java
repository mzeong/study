import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int minP = 50;
        for (int i = 1; i < n; i++) {
            minP = Math.min(minP, p[i]);
        }
        int cnt;
        if (minP <= p[0]) {
            cnt = m / minP;
        } else if (m - minP >= 0) {
            cnt = (m - minP) / p[0] + 1;
        } else {
            cnt = 1;
        }
        minP = Math.min(minP, p[0]);

        if (cnt == 1) {
            for (int i = n - 1; i >= 0; i--) {
                if (p[i] <= m) {
                    System.out.println(i);
                    break;
                }
            }
        } else {
            int[] result = new int[cnt];
            for (int i = 0; i < result.length; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (minP * (cnt - i - 1) <= m - p[j]) {
                        result[i] = j;
                        m -= p[j];
                        break;
                    }
                }
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < result.length; i++) {
                answer.append(result[i]);
            }
            System.out.println(answer);
        }
    }
}
