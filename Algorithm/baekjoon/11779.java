import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        int[] prev = new int[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(a, 0));
        dist[a] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.number == b) {
                break;
            }

            if (dist[cur.number] < cur.cost) {
                continue;
            }
            for (Node nxt : graph.get(cur.number)) {
                if (dist[nxt.number] > cur.cost + nxt.cost) {
                    dist[nxt.number] = cur.cost + nxt.cost;
                    prev[nxt.number] = cur.number;
                    pq.offer(new Node(nxt.number, dist[nxt.number]));
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(dist[b]).append(System.lineSeparator());
        Stack<Integer> s = new Stack<>();
        for (int i = b; prev[i] != 0; i = prev[i]) {
            s.push(i);
        }
        s.push(a);
        answer.append(s.size()).append(System.lineSeparator());
        while (!s.isEmpty()) {
            answer.append(s.pop()).append(' ');
        }
        System.out.println(answer);
    }

    private static class Node implements Comparable<Node> {

        int number;
        int cost;

        public Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
