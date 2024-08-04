import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] a;
    private static int[] op;
    private static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        sol(1, a[1]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void sol(int k, int rst) {
        if (k == n) {
            min = Math.min(min, rst);
            max = Math.max(max, rst);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] <= 0) {
                continue;
            }

            op[i]--;
            if (i == 0) {
                sol(k + 1, rst + a[k + 1]);
            } else if (i == 1) {
                sol(k + 1, rst - a[k + 1]);
            } else if (i == 2) {
                sol(k + 1, rst * a[k + 1]);
            } else {
                sol(k + 1, rst / a[k + 1]);
            }
            op[i]++;
        }
    }
}
