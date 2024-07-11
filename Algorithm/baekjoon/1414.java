import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Edge> edges = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                int w = input.charAt(j);
                if (w >= 'a' && w <= 'z') {
                    w -= 'a' - 1;
                } else if (w >= 'A' && w <= 'Z') {
                    w -= 'A' - 27;
                } else {
                    w = 0;
                }

                if (n == 1) {
                    System.out.println(w);
                    System.exit(0);
                }
                
                total += w;
                if (i == j || w == 0) {
                    continue;
                }
                edges.add(new Edge(i, j, w));
            }
        }
        Collections.sort(edges);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int cnt = 0, rst = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (union(edge.s, edge.e)) {
                cnt += 1;
                rst += edge.w;
            }
            if (cnt == n - 1) {
                System.out.println(total - rst);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        }
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
        return true;
    }

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge> {

        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return this.w - other.w;
        }
    }
}
