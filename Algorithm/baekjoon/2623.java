import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Set<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new HashSet<>());
        }
        int[] degree = new int[n + 1];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            while (--k > 0) {
                int e = Integer.parseInt(st.nextToken());
                if (graph.get(s).add(e)) {
                    degree[e]++;
                }
                s = e;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);

            for (int nxt : graph.get(cur)) {
                degree[nxt]--;
                if (degree[nxt] == 0) {
                    q.add(nxt);
                }
            }
        }

        if (result.size() != n) {
            System.out.println(0);
        } else {
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                answer.append(result.get(i)).append(System.lineSeparator());
            }
            System.out.println(answer);
        }
    }
}
