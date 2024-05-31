import java.io.*;
import java.util.*;

public class Main {

    private static int n, m, wallCount, emptyCount, answer;
    private static final int[] laboratory = new int[64];
    private static final int[] wallPosition = new int[3];
    private static final Queue<Integer> virusPosition = new LinkedList<>();
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int p = i * m + j;
                laboratory[p] = Integer.parseInt(st.nextToken());
                if (laboratory[p] == 2) {
                    virusPosition.offer(p);
                } else if (laboratory[p] == 1) {
                    wallCount++;
                }
            }
        }
        emptyCount = n * m - virusPosition.size() - wallCount;

        combination(0, n * m, 3);
        System.out.println(answer);
    }

    private static void combination(int start, int end, int r) {
        if (r == 0) {
            for (int i = 0; i < 3; i++) {
                laboratory[wallPosition[i]] = 1;
            }
            bfs();
            for (int i = 0; i < 3; i++) {
                laboratory[wallPosition[i]] = 0;
            }
            return;
        }

        for (int i = start; i < end; i++) {
            if (laboratory[i] == 0) {
                wallPosition[3 - r] = i;
                combination(i + 1, end, r - 1);
            }
        }
    }

    private static void bfs() {
        boolean[] visited = new boolean[64];
        Queue<Integer> q = new LinkedList<>();
        q.addAll(virusPosition);

        int result = emptyCount - 3;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int y = cur / m;
            int x = cur % m;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                int nxt = ny * m + nx;

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (laboratory[nxt] == 1 || laboratory[nxt] == 2) {
                    continue;
                }
                if (visited[nxt]) {
                    continue;
                }

                visited[nxt] = true;
                q.offer(nxt);
                result--;
            }
        }
        answer = Math.max(answer, result);
    }
}
