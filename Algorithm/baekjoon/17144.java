import java.io.*;
import java.util.*;

public class Main {
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[][] arr1 = new int[50][50];
    private static final int[][] arr2 = new int[50][50];
    private static final int[] aq = { -1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());

                if (arr1[i][j] == -1 && aq[0] == -1) {
                    aq[0] = i;
                    aq[1] = i + 1;
                }
            }
        }

        while (t-- > 0) {
            sol(r, c);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr1[i][j] = arr2[i][j];
                    arr2[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                answer += arr1[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void sol(int r, int c) {
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (arr1[y][x] == -1) continue;

                int v = arr1[y][x] / 5;
                int d = 0;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                    if (arr1[ny][nx] == -1) continue;

                    arr2[ny][nx] += v;
                    d++;
                }
                arr2[y][x] += arr1[y][x] - v * d;
            }
        }

        // 위쪽 공기청정기
        for (int y = aq[0]; y > 0; y--) {
            arr2[y][0] = arr2[y - 1][0];
        }
        arr2[aq[0]][0] = 0;

        for (int x = 0; x < c - 1; x++) {
            arr2[0][x] = arr2[0][x + 1];
        }

        for (int y = 0; y < aq[0]; y++) {
            arr2[y][c - 1] = arr2[y + 1][c - 1];
        }

        for (int x = c - 1; x > 0; x--) {
            arr2[aq[0]][x] = arr2[aq[0]][x - 1];
        }

        // 아래쪽 공기청정기
        for (int y = aq[1]; y < r - 1; y++) {
            arr2[y][0] = arr2[y + 1][0];
        }
        arr2[aq[1]][0] = 0;

        for (int x = 0; x < c - 1; x++) {
            arr2[r - 1][x] = arr2[r - 1][x + 1];
        }

        for (int y = r - 1; y > aq[1]; y--) {
            arr2[y][c - 1] = arr2[y - 1][c - 1];
        }

        for (int x = c - 1; x > 0; x--) {
            arr2[aq[1]][x] = arr2[aq[1]][x - 1];
        }
    }
}
