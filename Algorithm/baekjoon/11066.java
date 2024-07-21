import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int input = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + input;
            }

            int[][] dp = new int[n + 1][n + 1];
            for (int m = 1; m < n; m++) {
                for (int i = 1; i + m <= n; i++) {
                    int j = i + m;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }
            answer.append(dp[1][n]).append("\n");
        }
        System.out.println(answer);
    }
}
