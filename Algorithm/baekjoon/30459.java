import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        double answer = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int base = a[j] - a[i];
                double target = 2.0 * r / base;

                int left = 0, right = m - 1;
                int result = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (b[mid] <= target) {
                        result = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                if (result == -1) {
                    continue;
                }
                double area = base * b[result] / 2.0;
                answer = Math.max(answer, area);
            }
        }

        if (answer == -1) {
            System.out.println(-1);
        } else {
            System.out.printf("%.1f\n", answer);
        }
    }
}
