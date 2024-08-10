import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] visited;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int n;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxLen = Math.max(maxLen, arr[i][j]);
            }
        }

        visited = new boolean[n][n];
        int answer = 1;
        int curLen = 1;
        while (curLen <= maxLen) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > curLen) {
                        dfs(i, j, curLen);
                        result++;
                    }
                }
            }
            answer = Math.max(answer, result);
            curLen++;
        }
        System.out.println(answer);
    }

    private static void dfs(int y, int x, int len) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (arr[ny][nx] <= len) {
                continue;
            }
            dfs(ny, nx, len);
        }
    }
}
