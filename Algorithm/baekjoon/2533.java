import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> edges;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        visited = new boolean[n + 1];
        dfs(1);
        System.out.println(answer);
    }

    private static boolean dfs(int cur) {
        visited[cur] = true;

        boolean leaf = true;
        boolean earlyAdopter = true;
        for (int nxt : edges.get(cur)) {
            if (visited[nxt]) {
                continue;
            }
            leaf = false;
            earlyAdopter = dfs(nxt) && earlyAdopter;
        }

        if (leaf) {
            return false;
        }
        if (!earlyAdopter) {
            answer++;
            return true;
        }
        return false;
    }
}
