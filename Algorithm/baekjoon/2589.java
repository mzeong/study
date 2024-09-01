import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static char[][] arr;
    private static int[][] visited;
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    Node result = bfs(new Node(i, j));
                    answer = Math.max(answer, visited[result.y][result.x]);
                }
            }
        }
        System.out.println(answer);
    }

    private static Node bfs(Node start) {
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        Queue<Node> q = new LinkedList<>();
        visited[start.y][start.x] = 0;
        q.add(start);

        Node result = start;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.y][cur.x] > visited[result.y][result.x]) {
                result = cur;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (arr[ny][nx] != 'L') {
                    continue;
                }
                if (visited[ny][nx] > visited[cur.y][cur.x] + 1) {
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                    q.add(new Node(ny, nx));
                }
            }
        }
        return result;
    }

    private static class Node {

        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
