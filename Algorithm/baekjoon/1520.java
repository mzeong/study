import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};
    private static int n, m;
    private static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[m - 1][n - 1] = 1;
        int answer = dfs(0, 0);
        System.out.println(answer);
    }

    private static int dfs(int y, int x) {
        if (dp[y][x] != -1) {
            return dp[y][x];
        }

        int rst = 0;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
                continue;
            }
            if (arr[ny][nx] < arr[y][x]) {
                rst += dfs(ny, nx);
            }
        }
        return dp[y][x] = rst;
    }
}
