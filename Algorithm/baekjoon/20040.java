import java.io.*;
import java.util.*;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] s = new int[m];
        int[] e = new int[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            if (find(s[i]) == find(e[i])) {
                System.out.println(i + 1);
                System.exit(0);
            }
            union(s[i], e[i]);
        }
        System.out.println(0);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}
