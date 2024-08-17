import java.io.*;

public class Main {

    private static Character[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new Character[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        String answer = sol(0, 0, n);
        System.out.println(answer);
    }

    private static String sol(int y, int x, int k) {
        if (k == 1) {
            return arr[y][x].toString();
        }

        int nk = k / 2;
        String a = sol(y, x, nk);
        String b = sol(y, x + nk, nk);
        String c = sol(y + nk, x, nk);
        String d = sol(y + nk, x + nk, nk);

        if (a.equals(b) && a.equals(c) && a.equals(d)) {
            if (a.equals("0") || a.equals("1")) {
                return a;
            }
        }
        return new StringBuilder("(").append(a).append(b).append(c).append(d).append(")").toString();
    }
}
