import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int sy = 1; sy + a - 1 <= n; sy++) {
            for (int sx = 1; sx + b + c - 1 <= m; sx++) {
                int ey = sy + a - 1;
                int ex = sx + b + c - 1;
                int rst = sum[ey][ex] - sum[sy - 1][ex] - sum[ey][sx - 1] + sum[sy - 1][sx - 1];
                answer = Math.min(answer, rst);
            }
        }
        for (int sy = 1; sy + a + b - 1 <= n; sy++) {
            for (int sx = 1; sx + c + a - 1 <= m; sx++) {
                int ey = sy + a + b - 1;
                int ex = sx + c + a - 1;
                int rst = sum[ey - b][ex - a] - sum[sy - 1][ex - a] - sum[ey - b][sx - 1] + sum[sy - 1][sx - 1];
                rst += sum[ey][ex] - sum[ey - b][ex] - sum[ey][ex - a] + sum[ey - b][ex - a];
                answer = Math.min(answer, rst);
            }
        }
        for (int sy = 1; sy + a + c - 1 <= n; sy++) {
            for (int sx = 1; sx + b + a - 1 <= m; sx++) {
                int ey = sy + a + c - 1;
                int ex = sx + b + a - 1;
                int rst = sum[ey - c][ex - a] - sum[sy - 1][ex - a] - sum[ey - c][sx - 1] + sum[sy - 1][sx - 1];
                rst += sum[ey][ex] - sum[ey - c][ex] - sum[ey][ex - a] + sum[ey - c][ex - a];
                answer = Math.min(answer, rst);
            }
        }
        System.out.println(answer);
    }
}
