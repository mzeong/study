import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, d;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    int result = sol(new int[]{i, j, k});
                    answer = Math.max(answer, result);
                }
            }
        }
        System.out.println(answer);
    }

    private static int sol(int[] archers) {
        int[][] visited = new int[n][m];
        for (int r = n; r > 0; r--) {
            for (int archer : archers) {
                Loop1:
                for (int cd = 1; cd <= d; cd++) {
                    for (int x = archer - cd + 1; x < archer + cd; x++) { // a - d + 1 ~ a + d - 1
                        int y = Math.abs(archer - x) + r - cd;

                        if (y < 0 || y >= r || x < 0 || x >= m) {
                            continue;
                        }
                        if (visited[y][x] > r) {
                            continue;
                        }
                        if (arr[y][x] == 1) {
                            visited[y][x] = r;
                            break Loop1;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] > 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
