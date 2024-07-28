import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int[][] dp = new int[n + 1][4];
        for (int j = 1; j <= 3; j++) {
            for (int i = j * m; i <= n; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - m][j - 1] + sum[i] - sum[i - m]);
            }
        }
        System.out.println(dp[n][3]);
    }
}
