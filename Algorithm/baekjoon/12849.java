import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = List.of(
                List.of(),
                List.of(2, 3),
                List.of(1, 3, 4),
                List.of(1, 2, 4, 5),
                List.of(2, 3, 5, 6),
                List.of(3, 4, 6, 7),
                List.of(4, 5, 8),
                List.of(5, 8),
                List.of(6, 7)
        );

        int[][] dp = new int[d + 1][graph.size()];
        dp[0][1] = 1;
        for (int t = 1; t <= d; t++) {
            for (int v = 1; v < graph.size(); v++) {
                for (int nv : graph.get(v)) {
                    dp[t][v] += dp[t - 1][nv];
                    dp[t][v] %= MOD;
                }
            }
        }
        System.out.println(dp[d][1]);
    }
}
