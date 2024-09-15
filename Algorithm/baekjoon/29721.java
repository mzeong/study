import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Coord> piece = new HashSet<>();
        Set<Coord> result = new HashSet<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            result.remove(new Coord(y, x));
            piece.add(new Coord(y, x));

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir] * 2;
                int nx = x + dx[dir] * 2;

                if (ny <= 0 || ny > n || nx <= 0 || nx > n) {
                    continue;
                }
                if (piece.contains(new Coord(ny, nx))) {
                    continue;
                }
                result.add(new Coord(ny, nx));
            }
        }

        System.out.println(result.size());
    }

    static class Coord {

        int y;
        int x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coord coord = (Coord) o;
            return y == coord.y && x == coord.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
