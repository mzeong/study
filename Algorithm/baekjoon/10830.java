import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1_000;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = square(matrix, b);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer.append(result[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static int[][] square(int[][] matrix, long b) {
        if (b == 1) {
            return matrix;
        }
        int[][] result = square(matrix, b / 2);
        if (b % 2 == 0) {
            return mul(result, result);
        } else {
            return mul(mul(result, result), matrix);
        }
    }

    private static int[][] mul(int[][] matrix1, int[][] matrix2) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += matrix1[i][k] * matrix2[k][j];
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }
}
