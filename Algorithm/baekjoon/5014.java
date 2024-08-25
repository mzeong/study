import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int answer = -1;

        int[] visited = new int[f + 1];
        Arrays.fill(visited, 1_000_001);

        Queue<Integer> q = new LinkedList<>();
        visited[s] = 0;
        q.offer(s);
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == g) {
                answer = visited[cur];
                break;
            }

            if (cur + u <= f && visited[cur + u] > visited[cur] + 1) {
                visited[cur + u] = visited[cur] + 1;
                q.offer(cur + u);
            }
            if (cur - d > 0 && visited[cur - d] > visited[cur] + 1) {
                visited[cur - d] = visited[cur] + 1;
                q.offer(cur - d);
            }
        }
        System.out.println(answer != -1 ? answer : "use the stairs");
    }
}
