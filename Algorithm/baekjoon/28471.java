import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dy = {-1, -1, -1, 0, 0, 1, 1};
    private static final int[] dx = {-1, 0, 1, -1, 1, -1, 1};

    public static final int ALPHABET_CNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Point> q = new LinkedList<>();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = input.charAt(j);

                if (ch == '.' || ch == 'F') {
                    arr[i][j] = 0;
                } else if (ch == '#') {
                    arr[i][j] = -1;
                }

                if (ch == 'F') {
                    arr[i][j] = 1;
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 7; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue;
                }
                if (arr[ny][nx] == -1 || arr[ny][nx] == 1) {
                    continue;
                }

                arr[ny][nx] = 1;
                q.add(new Point(ny, nx));
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer - 1);
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
