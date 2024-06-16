import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] answer = new int[100_001];
        int[] visited = new int[100_001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        visited[n] = 0;
        q.add(n);
        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                answer[visited[cur]]++;
                continue;
            }

            if (cur - 1 >= 0 && visited[cur - 1] >= visited[cur] + 1) {
                visited[cur - 1] = visited[cur] + 1;
                q.add(cur - 1);
            }
            if (cur + 1 <= 100_000 && visited[cur + 1] >= visited[cur] + 1) {
                visited[cur + 1] = visited[cur] + 1;
                q.add(cur + 1);
            }
            if (cur * 2 <= 100_000 && visited[cur * 2] >= visited[cur] + 1) {
                visited[cur * 2] = visited[cur] + 1;
                q.add(cur * 2);
            }
        }

        for (int i = 0; i <= 100_000; i++) {
            if (answer[i] > 0) {
                System.out.printf("%d %d", i, answer[i]);
                break;
            }
        }
    }
}
