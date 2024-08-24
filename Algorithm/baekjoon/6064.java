import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int k = m * n;
            for (int i = m; i <= m * n; i += m) {
                if (i % n == 0) {
                    k = i;
                    break;
                }
            }

            int result = -1;
            for (int i = x; i <= k; i += m) {
                int j = i % n == 0 ? n : i % n;
                if (j == y) {
                    result = i;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
