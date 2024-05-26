import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n + 1][3][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[1][0][0] = arr[1][0];
        dp[1][1][1] = arr[1][1];
        dp[1][2][2] = arr[1][2];

        dp[2][0][1] = arr[2][0] + dp[1][1][1];
        dp[2][0][2] = arr[2][0] + dp[1][2][2];
        dp[2][1][0] = arr[2][1] + dp[1][0][0];
        dp[2][1][2] = arr[2][1] + dp[1][2][2];
        dp[2][2][0] = arr[2][2] + dp[1][0][0];
        dp[2][2][1] = arr[2][2] + dp[1][1][1];

        for (int i = 3; i <= n; i++) {
            dp[i][0][0] = arr[i][0] + Math.min(dp[i - 1][1][0], dp[i - 1][2][0]);
            dp[i][0][1] = arr[i][0] + Math.min(dp[i - 1][1][1], dp[i - 1][2][1]);
            dp[i][0][2] = arr[i][0] + Math.min(dp[i - 1][1][2], dp[i - 1][2][2]);

            dp[i][1][0] = arr[i][1] + Math.min(dp[i - 1][0][0], dp[i - 1][2][0]);
            dp[i][1][1] = arr[i][1] + Math.min(dp[i - 1][0][1], dp[i - 1][2][1]);
            dp[i][1][2] = arr[i][1] + Math.min(dp[i - 1][0][2], dp[i - 1][2][2]);

            dp[i][2][0] = arr[i][2] + Math.min(dp[i - 1][0][0], dp[i - 1][1][0]);
            dp[i][2][1] = arr[i][2] + Math.min(dp[i - 1][0][1], dp[i - 1][1][1]);
            dp[i][2][2] = arr[i][2] + Math.min(dp[i - 1][0][2], dp[i - 1][1][2]);
        }

        int tmp0 = Math.min(dp[n][0][1], dp[n][0][2]);
        int tmp1 = Math.min(dp[n][1][0], dp[n][1][2]);
        int tmp2 = Math.min(dp[n][2][0], dp[n][2][1]);
        int answer = Math.min(tmp0, tmp1);
        answer = Math.min(answer, tmp2);

        System.out.println(answer);
    }
}
