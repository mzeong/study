import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<Fireball> fireballs;
    private static List<Fireball>[][] arr;
    private static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        fireballs = new ArrayList<>();
        arr = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            fireballs.add(new Fireball(r, c, m, s, d));
        }

        while (K-- > 0) {
            move();
            happen();
        }
        int answer = 0;
        for (Fireball fb : fireballs) {
            answer += fb.m;
        }
        System.out.println(answer);
    }

    private static void move() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (Fireball fb : fireballs) {
            int nr = (fb.r + dr[fb.d] * fb.s % N + N) % N;
            int nc = (fb.c + dc[fb.d] * fb.s % N + N) % N;
            arr[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
        }
    }

    private static void happen() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                List<Fireball> fbs = arr[r][c];
                if (fbs.size() <= 1) {
                    continue;
                }

                Fireball sum = fbs.get(0);
                boolean allSame = true;
                for (int i = 1; i < fbs.size(); i++) {
                    Fireball fb = fbs.get(i);
                    sum.m += fb.m;
                    sum.s += fb.s;
                    if (sum.d % 2 != fb.d % 2) {
                        allSame = false;
                    }
                }

                sum.m /= 5;
                sum.s /= fbs.size();

                arr[r][c] = new ArrayList<>();
                if (sum.m == 0) {
                    continue;
                }
                for (int i = allSame ? 0 : 1; i < 8; i += 2) {
                    arr[r][c].add(new Fireball(r, c, sum.m, sum.s, i));
                }
            }
        }
        fireballs = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (Fireball fb : arr[r][c]) {
                    fireballs.add(fb);
                }
            }
        }
    }

    private static class Fireball {

        int r;
        int c;
        int m;
        int s;
        int d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
