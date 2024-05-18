import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    }
                    if (arr[i][k] == Integer.MAX_VALUE || arr[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        arr[j][i] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result[i] += arr[i][j];
            }
        }

        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (result[i] < min) {
                answer = i;
                min = result[i];
            }
        }
        System.out.println(answer);
    }
}
