import java.io.*;
import java.util.*;

public class Main {

    private static final List<List<Node>> graph = new ArrayList<>();
    private static final boolean[] visited = new boolean[10001];
    private static final int[] result = new int[2];

    private static class Node {

        int number;
        int weight;

        Node(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dfs(1, 0);

        for (int i = 0; i <= n; i++) {
            visited[i] = false;
        }
        dfs(result[1], 0);

        System.out.println(result[0]);
    }

    private static void dfs(int cur, int w) {
        visited[cur] = true;

        if (result[0] < w) {
            result[0] = w;
            result[1] = cur;
        }

        for (Node nxt : graph.get(cur)) {
            if (!visited[nxt.number]) {
                dfs(nxt.number, w + nxt.weight);
            }
        }
    }
}
