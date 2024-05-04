import java.io.*;
import java.util.*;
    
public class Main
{
    private static class Node implements Comparable<Node> {
        
        private final int idx;
        private final int cost;
        
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
		    graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    int c = Integer.parseInt(st.nextToken());
		    
		    graph[a].add(new Node(b, c));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int dist[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
		    dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, dist[s]));
		
		boolean visited[] = new boolean[n + 1];
		
		while (!pq.isEmpty()) {
		    Node cur = pq.poll();
		    
		    if (visited[cur.idx]) continue;
		    visited[cur.idx] = true;
		    
		    for (Node nxt : graph[cur.idx]) {
		        if (dist[nxt.idx] > dist[cur.idx] + nxt.cost) { 
		            dist[nxt.idx] = dist[cur.idx] + nxt.cost;
		            pq.offer(new Node(nxt.idx, dist[nxt.idx]));
		        }
		    }
		}
		
		System.out.println(dist[e]);
	}
}
