import java.io.*;

public class Main {

    private static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[i][1] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = dp[i - 2][j - 1] + dp[i - 1][j];
                dp[i][j] %= MOD;
            }
        }
        System.out.println((dp[n - 3][k - 1] + dp[n - 1][k]) % MOD);
    }
}
