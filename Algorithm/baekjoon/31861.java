import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (Math.abs(j - k) >= n) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += dp[m][i];
            answer %= MOD;
        }
        System.out.println(answer);
    }
}
