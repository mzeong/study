import java.io.*;
import java.util.*;

public class Main {

    private static List<Lecture> lectures;
    private static int answer;
    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (w != 5) {
                lectures.add(new Lecture(w, s, e));
            }
        }

        Collections.sort(lectures);

        sol(0, -1);
        System.out.println(answer);
    }

    private static void sol(int sum, int idx) {
        if (sum == k) {
            answer++;
            return;
        }

        Lecture cur = idx >= 0 ? lectures.get(idx) : null;
        for (int i = idx + 1; i < lectures.size(); i++) {
            Lecture nxt = lectures.get(i);

            if (cur == null || cur.w != nxt.w || cur.e < nxt.s) {
                sol(sum + lectures.get(i).u, i);
            }
        }
    }

    static class Lecture implements Comparable<Lecture> {

        int w;
        int s;
        int e;
        int u;

        public Lecture(int w, int s, int e) {
            this.w = w;
            this.s = s;
            this.e = e;
            this.u = e - s + 1;
        }

        @Override
        public int compareTo(Lecture other) {
            if (this.w != other.w) {
                return this.w - other.w;
            }
            if (this.s != other.s) {
                return this.s - other.s;
            }
            return this.e - other.e;
        }
    }
}
