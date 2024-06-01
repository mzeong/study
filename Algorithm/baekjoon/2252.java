import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        int[] cnt = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            cnt[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer.append(cur).append(" ");

            for (int nxt : g.get(cur)) {
                cnt[nxt]--;
                if (cnt[nxt] == 0) {
                    q.offer(nxt);
                }
            }
        }
        System.out.println(answer);
    }
}
