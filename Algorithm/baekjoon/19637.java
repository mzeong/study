import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] t = new String[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = st.nextToken();
            p[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());

            int left = 0, right = n - 1;
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;

                if (power <= p[mid]) {
                    right = mid - 1;
                    result = mid;
                } else if (p[mid] < power) {
                    left = mid + 1;
                }
            }
            answer.append(t[result]).append("\n");
        }
        System.out.println(answer);
    }
}
