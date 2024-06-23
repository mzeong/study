import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] arr, visited;
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                Character ch = str.charAt(j);
                if (ch == 'U') {
                    arr[i][j] = 3;
                } else if (ch == 'D') {
                    arr[i][j] = 1;
                } else if (ch == 'L') {
                    arr[i][j] = 2;
                } else if (ch == 'R') {
                    arr[i][j] = 0;
                }
            }
        }
        
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j, i * m + j + 1);
                }
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int y, int x, int idx) {
        visited[y][x] = idx;

        int ny = y + dy[arr[y][x]];
        int nx = x + dx[arr[y][x]];

        if (visited[ny][nx] == 0) {
            dfs(ny, nx, idx);
        } else if (visited[ny][nx] == idx) {
            answer++;
        }
    }
}
