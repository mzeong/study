import java.io.*;
import java.util.*;

public class Main {

    private static boolean[][] visited;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int n, m;
    private static char[][] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                a[i][j] = input.charAt(j);
            }
        }
        b = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                b[i][j] = input.charAt(j);
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, a[i][j], b[i][j]);
                }
            }
        }
        System.out.println("YES");
    }

    private static void dfs(int y, int x, char aColor, char bColor) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (a[ny][nx] != aColor) {
                continue;
            }
            if (b[ny][nx] != bColor) {
                System.out.println("NO");
                System.exit(0);
            }
            dfs(ny, nx, aColor, bColor);
        }
    }
}
