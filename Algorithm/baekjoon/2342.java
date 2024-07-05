import java.io.*;
import java.util.*;

public class Main {

    private static final int[][] power = {
            {1, 2, 2, 2, 2},
            {2, 1, 3, 4, 3},
            {2, 3, 1, 3, 4},
            {2, 4, 3, 1, 3},
            {2, 3, 4, 3, 1}
    };

    private static List<Integer> arr;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        int seq = -1;
        while (seq != 0) {
            seq = Integer.parseInt(st.nextToken());
            arr.add(seq);
        }

        dp = new int[arr.size() - 1][5][5];
        int answer = sol(0, 0, 0);
        System.out.println(answer);
    }

    private static int sol(int i, int l, int r) {
        if (i == arr.size() - 1) {
            return 0;
        }
        if (dp[i][l][r] != 0) {
            return dp[i][l][r];
        }

        return dp[i][l][r] = Math.min(
                sol(i + 1, arr.get(i), r) + power[l][arr.get(i)],
                sol(i + 1, l, arr.get(i)) + power[r][arr.get(i)]
        );
    }
}
