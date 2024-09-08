import java.io.*;
import java.util.*;

public class Main {

    private static final List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, 1);
            Arrays.fill(visited, false);
        }
        System.out.println(0);
    }

    private static void dfs(int cur, int cnt) {
        if (cnt == 5) {
            System.out.println(1);
            System.exit(0);
        }

        for (int nxt : graph.get(cur)) {
            if (visited[nxt]) {
                continue;
            }
            visited[nxt] = true;
            dfs(nxt, cnt + 1);
            visited[nxt] = false;
        }
    }
}
