import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[][] arr = new int[100][100];
    private static final int[][] visited = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && visited[i][j] < 2) {
                        arr[i][j] = 1;
                        flag = false;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
            if (flag) break;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = 0;
                }
            }
            dfs(0, 0, n, m);
            answer++;
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int n, int m) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (arr[ny][nx] == 1) {
                visited[ny][nx]++;
            } else if (visited[ny][nx] == 0){
                dfs(ny, nx, n, m);
            }
        }
    }
}
