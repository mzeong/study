import java.io.*;
import java.util.*;

public class Main {

    private static final List<Coord> blank = new ArrayList<>();
    private static boolean[][] row = new boolean[9][10];
    private static boolean[][] col = new boolean[9][10];
    private static boolean[][] squ = new boolean[9][10];
    private static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                int k = input.charAt(j) - '0';

                if (k == 0) {
                    blank.add(new Coord(i, j));
                }
                row[i][k] = true;
                col[j][k] = true;
                squ[i / 3 * 3 + j / 3][k] = true;
                arr[i][j] = k;
            }
        }

        sudoku(0);
    }

    private static void sudoku(int idx) {
        if (idx == blank.size()) {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    answer.append(arr[i][j]);
                }
                answer.append("\n");
            }
            System.out.println(answer);
            System.exit(0);
        }

        int i = blank.get(idx).r;
        int j = blank.get(idx).c;

        for (int k = 1; k <= 9; k++) {
            if (!row[i][k] && !col[j][k] && !squ[i / 3 * 3 + j / 3][k]) {
                row[i][k] = true;
                col[j][k] = true;
                squ[i / 3 * 3 + j / 3][k] = true;
                arr[i][j] = k;
                sudoku(idx + 1);

                row[i][k] = false;
                col[j][k] = false;
                squ[i / 3 * 3 + j / 3][k] = false;
            }
        }
    }

    private static class Coord {

        int r;
        int c;

        public Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
