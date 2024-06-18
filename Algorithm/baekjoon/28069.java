import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    int[] visited = new int[n + 1];
	    Arrays.fill(visited, 1_000_001);
	    
	    Queue<Integer> q = new LinkedList<>();
	    visited[0] = 0;
	    q.add(0);
	    while (!q.isEmpty()) {
	        int cur = q.poll();
	        
	        int[] action = { cur + 1, cur + cur / 2 };
	        for (int nxt : action) {
	            if (nxt <= n && visited[nxt] > visited[cur] + 1) {
    	            visited[nxt] = visited[cur] + 1;
    	            q.add(nxt);
    	        }
	        }
	    }
	    System.out.println(visited[n] <= k ? "minigimbob" : "water");
	}
}
