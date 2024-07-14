import java.io.*;
import java.util.*;

public class Main {

    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];
        List<Integer> cy = new ArrayList<>();
        List<Integer> cx = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            String input = br.readLine();
            for (int j = 0; j < w; j++) {
                char ch = input.charAt(j);
                if (ch == '*') {
                    arr[i][j] = 1;
                } else if (ch == 'C') {
                    arr[i][j] = 2;
                    cy.add(i);
                    cx.add(j);
                }
            }
        }

        int[][][] visited = new int[h][w][4];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int dir = 0; dir < 4; dir++) {
            visited[cy.get(0)][cx.get(0)][dir] = 0;
        }
        pq.add(new Node(cy.get(0), cx.get(0), -1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.y == cy.get(1) && cur.x == cx.get(1)) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    continue;
                }
                if (arr[ny][nx] == 1) {
                    continue;
                }

                int nm;
                if (cur.dir == -1) {
                    nm = 0;
                } else if (cur.dir == i) {
                    nm = visited[cur.y][cur.x][cur.dir];
                } else {
                    nm = visited[cur.y][cur.x][cur.dir] + 1;
                }
                if (visited[ny][nx][i] > nm) {
                    visited[ny][nx][i] = nm;
                    pq.add(new Node(ny, nx, i, visited[ny][nx][i]));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int dir = 0; dir < 4; dir++) {
            answer = Math.min(answer, visited[cy.get(1)][cx.get(1)][dir]);
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {

        int y;
        int x;
        int dir;
        int mir;

        public Node(int y, int x, int dir, int mir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.mir = mir;
        }

        @Override
        public int compareTo(Node o) {
            return this.mir - o.mir;
        }
    }
}
