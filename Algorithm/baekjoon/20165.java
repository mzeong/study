import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[][] arr;
    private static boolean[][] fall;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fall = new boolean[n][m];
        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            String d = st.nextToken();
            attack(y, x, d);

            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken()) - 1;
            x = Integer.parseInt(st.nextToken()) - 1;
            defense(y, x);
        }

        StringBuilder answer = new StringBuilder();
        answer.append(count).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer.append(fall[i][j] ? "F" : "S").append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void attack(int y, int x, String d) {
        int dy = Objects.equals(d, "E") || Objects.equals(d, "W") ? 0 : 1;
        int dx = Objects.equals(d, "E") || Objects.equals(d, "W") ? 1 : 0;
        int k = Objects.equals(d, "E") || Objects.equals(d, "S") ? 1 : -1;

        int len = fall[y][x] ? 0 : arr[y][x];
        fall[y][x] = true;
        count++;
        while (--len > 0) {
            y += dy * k;
            x += dx * k;

            if (y < 0 || y >= n || x < 0 || x >= m) {
                break;
            }
            if (fall[y][x]) {
                continue;
            }
            len = Math.max(len, fall[y][x] ? len : arr[y][x]);
            fall[y][x] = true;
            count++;
        }
    }

    private static void defense(int y, int x) {
        fall[y][x] = false;
    }
}
