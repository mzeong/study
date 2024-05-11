import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100_001][3];
        int[][] dp = new int[100_001][3];

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int c = 1; c <= 2; c++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int r = 1; r <= n; r++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][1] = arr[1][1];
            dp[1][2] = arr[1][2];
            for (int i = 2; i <= n; i++) {
                dp[i][1] = Math.max(dp[i - 1][2], Math.max(dp[i - 2][1], dp[i - 2][2])) + arr[i][1];
                dp[i][2] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][1], dp[i - 2][2])) + arr[i][2];
            }

            int result = Math.max(dp[n][1], dp[n][2]);
            System.out.println(result);
        }
    }
}
