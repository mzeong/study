import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());

        int[][] visited = new int[s + 1][s + 1];
        for (int i = 0; i <= s; i++) {
            for (int j = 0; j <= s; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Node> q = new LinkedList<>();
        visited[0][1] = 0;
        q.add(new Node(0, 1));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int clipboard = cur.clipboard;
            int screen = cur.screen;
            int sec = visited[clipboard][screen];

            if (screen == s) {
                System.out.println(sec);
                break;
            }
            if (visited[screen][screen] > sec + 1) {
                visited[screen][screen] = sec + 1;
                q.add(new Node(screen, screen));
            }
            if (screen + clipboard <= s && visited[clipboard][screen + clipboard] > sec + 1) {
                visited[clipboard][screen + clipboard] = sec + 1;
                q.add(new Node(clipboard, screen + clipboard));
            }
            if (screen - 1 >= 0 && visited[clipboard][screen - 1] > sec + 1) {
                visited[clipboard][screen - 1] = sec + 1;
                q.add(new Node(clipboard, screen - 1));
            }
        }
    }

    static class Node {

        int clipboard;
        int screen;

        public Node(int clipboard, int screen) {
            this.clipboard = clipboard;
            this.screen = screen;
        }
    }
}
