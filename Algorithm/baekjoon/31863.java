import java.io.*;
import java.util.*;

public class Main {

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int total = 0;

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);

                if (arr[i][j] == '@') {
                    visited[i][j]++;
                    q.add(new Point(i, j));
                }
                if (arr[i][j] == '*' || arr[i][j] == '#') {
                    total++;
                }
            }
        }

        int answer = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            int square = arr[cur.y][cur.x] == '@' ? 2 : 1;
            for (int k = 1; k <= square; k++) {
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i] * k;
                    int nx = cur.x + dx[i] * k;

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                        continue;
                    }
                    if (arr[ny][nx] == '|') {
                        continue;
                    }
                    if (k == 2 && arr[cur.y + dy[i]][cur.x + dx[i]] == '|') {
                        continue;
                    }

                    visited[ny][nx]++;

                    if (arr[ny][nx] == '*' && visited[ny][nx] == 1 ||
                            arr[ny][nx] == '#' && visited[ny][nx] == 2) {
                        answer++;
                        q.add(new Point(ny, nx));
                    }
                }
            }
        }

        System.out.printf("%d %d", answer, total - answer);
    }

    static class Point {

        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
