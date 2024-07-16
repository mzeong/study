import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<List<Pair>> roads = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            List<Pair> list = new ArrayList<>();
            for (int c = 0; c < n; c++) {
                if (list.isEmpty() || list.get(list.size() - 1).len != arr[r][c]) {
                    list.add(new Pair(arr[r][c], 1));
                } else {
                    list.get(list.size() - 1).cnt++;
                }
            }
            roads.add(list);
        }
        for (int c = 0; c < n; c++) {
            List<Pair> list = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                if (list.isEmpty() || list.get(list.size() - 1).len != arr[r][c]) {
                    list.add(new Pair(arr[r][c], 1));
                } else {
                    list.get(list.size() - 1).cnt++;
                }
            }
            roads.add(list);
        }

        int answer = 0;
        for (List<Pair> list : roads) {
            boolean rst = true;
            for (int idx = 0; idx < list.size() - 1 && rst; idx++) {
                Pair a = list.get(idx);
                Pair b = list.get(idx + 1);
                if (Math.abs(a.len - b.len) > 1) {
                    rst = false;
                } else if (a.len < b.len && a.cnt < l) {
                    rst = false;
                } else if (a.len > b.len) {
                    if (b.cnt < l) {
                        rst = false;
                    }
                    if (idx + 1 < list.size() - 1 && b.len < list.get(idx + 2).len && b.cnt < 2 * l) {
                        rst = false;
                    }
                }
            }
            if (rst) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static class Pair {

        int len;
        int cnt;

        public Pair(int len, int cnt) {
            this.len = len;
            this.cnt = cnt;
        }
    }
}
