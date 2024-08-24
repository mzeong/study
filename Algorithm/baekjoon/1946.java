import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Grade> grades = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                grades.add(new Grade(first, second));
            }

            Collections.sort(grades);

            int answer = 1;
            int standard = grades.get(0).second;
            for (int i = 0; i < n; i++) {
                if (grades.get(i).second < standard) {
                    answer++;
                    standard = grades.get(i).second;
                }
            }

            System.out.println(answer);
        }
    }

    static class Grade implements Comparable<Grade> {

        int first;

        int second;

        public Grade(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Grade other) {
            return this.first - other.first;
        }
    }
}
