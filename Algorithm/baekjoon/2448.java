import java.io.*;
import java.util.*;

public class Main {

    private static final char[][] init = {
            {' ', ' ', '*', ' ', ' '},
            {' ', '*', ' ', '*', ' '},
            {'*', '*', '*', '*', '*'}
    };
    private static char[][] rst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        rst = new char[n][2 * n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(rst[i], ' ');
        }
        sol(n, 0, 0);

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                answer.append(rst[i][j]);
            }
            answer.append(System.lineSeparator());
        }
        System.out.println(answer);
    }

    private static void sol(int n, int y, int x) {
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    rst[y + i][x + j] = init[i][j];
                }
            }
            return;
        }

        sol(n / 2, y, x + 2 * n / 4);
        sol(n / 2, y + n / 2, x);
        sol(n / 2, y + n / 2, x + n);
    }
}
