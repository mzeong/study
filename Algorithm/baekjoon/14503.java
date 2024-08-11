import java.io.*;
import java.util.*;

public class Main {

    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static int[][] arr;
    private static int answer;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];
        dfs(sy, sx, sd);
    }

    private static void dfs(int y, int x, int d) {
        if (arr[y][x] == 0 && !visited[y][x]) {
            visited[y][x] = true;
            answer++;
        }

        for (int i = 0, nd = d; i < 4; i++) {
            nd = (nd + 4 - 1) % 4;
            int ny = y + dy[nd];
            int nx = x + dx[nd];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue;
            }
            if (arr[ny][nx] == 1 || visited[ny][nx]) {
                continue;
            }
            dfs(ny, nx, nd);
        }

        int nd = (d + 4 - 2) % 4;
        int ny = y + dy[nd];
        int nx = x + dx[nd];
        if (ny >= 0 && ny < n && nx >= 0 && nx < m && arr[ny][nx] == 0) {
            dfs(ny, nx, d);
        } else {
            System.out.println(answer);
            System.exit(0);
        }
    }
}
