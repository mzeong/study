import java.io.*;

public class Main {

    private static int n;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};
    private static Character[][] arr = new Character[100][100];
    private static boolean[][] visited = new boolean[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = row.charAt(j);
            }
        }

        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    boolean r = arr[i][j] == 'R' ? true : false;
                    boolean g = arr[i][j] == 'G' ? true : false;
                    boolean b = arr[i][j] == 'B' ? true : false;

                    visited[i][j] = true;
                    dfs(i, j, r, g, b);
                    answer[0]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    boolean r = arr[i][j] == 'R' || arr[i][j] == 'G' ? true : false;
                    boolean g = arr[i][j] == 'R' || arr[i][j] == 'G' ? true : false;
                    boolean b = arr[i][j] == 'B' ? true : false;

                    visited[i][j] = true;
                    dfs(i, j, r, g, b);
                    answer[1]++;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void dfs(int y, int x, boolean r, boolean g, boolean b) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }

            if (arr[ny][nx] == 'R' && r || arr[ny][nx] == 'G' && g || arr[ny][nx] == 'B' && b) {
                visited[ny][nx] = true;
                dfs(ny, nx, r, g, b);
            }
        }
    }
}
