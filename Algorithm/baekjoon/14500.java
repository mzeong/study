import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int m;
    private static int[][] arr = new int[500][500];
    private static int answer = 0;
    private static boolean[][] visited = new boolean[500][500];
    private static int[] dy = { 0, 1, 0, -1 };
    private static int[] dx = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                visited[y][x] = true;
                dfs(y, x, 1, arr[y][x]);
                visited[y][x] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int count, int score) {
        if (count == 4) {
            answer = Math.max(answer, score);
            return;
        }

        if (count == 1) { // ㅏ, ㅜ, ㅓ, ㅗ 모양 테트로미노
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                pq.add(arr[ny][nx]);
            }

            if (pq.size() == 4) {
                pq.poll();
            }
            if (pq.size() == 3) {
                int tmp = score;
                while (!pq.isEmpty()) {
                    tmp += pq.poll();
                }
                answer = Math.max(answer, tmp);
            }
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (count == 3 && score + arr[ny][nx] < answer) continue;

            visited[ny][nx] = true;
            dfs(ny, nx, count + 1, score + arr[ny][nx]);
            visited[ny][nx] = false;
        }
    }
}
