import java.io.*;
import java.util.*;

public class Main {

    private static int m, n;
    private static boolean[][] arr;
    private static int[][] visited;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static int result;
    private static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new boolean[m][n];
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int ey = m - Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken());
            int sy = m - Integer.parseInt(st.nextToken());

            for (int i = sy; i <= ey; i++) {
                for (int j = sx; j < ex; j++) {
                    arr[i][j] = true;
                }
            }
        }

        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!arr[i][j] && visited[i][j] == 0) {
                    result = 0;
                    visited[i][j] = 1;
                    dfs(i, j);
                    results.add(result);
                }
            }
        }

        Collections.sort(results);

        StringBuilder answer = new StringBuilder();
        answer.append(results.size()).append("\n");
        for (int i = 0; i < results.size(); i++) {
            answer.append(results.get(i)).append(" ");
        }
        System.out.println(answer);
    }

    private static void dfs(int y, int x) {
        result = Math.max(result, visited[y][x]);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= m || nx < 0 || nx >= n) {
                continue;
            }
            if (arr[ny][nx]) {
                continue;
            }
            if (visited[ny][nx] == 0) {
                visited[ny][nx] = result + 1;
                dfs(ny, nx);
            }
        }
    }
}
