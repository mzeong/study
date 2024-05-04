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
		
		int v = Integer.parseInt(br.readLine());
		
		ArrayList<Node>[] graph = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
		    graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < v; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    while (true) {
		        int b = Integer.parseInt(st.nextToken());
		        if (b == -1) break;
		        int c = Integer.parseInt(st.nextToken());
		        graph[a].add(new Node(b, c));
		    }
		}
		
		Node n1 = bfs(1, graph, v);
		Node n2 = bfs(n1.idx, graph, v);
		
		System.out.println(n1.cost > n2.cost ? n1.cost : n2.cost);
	}
	
	private static Node bfs(int s, ArrayList<Node>[] graph, int v) {
	    Queue<Node> q = new LinkedList<>();
	    q.add(new Node(s, 0));
	    
	    boolean visited[] = new boolean[v + 1];
	    visited[s] = true;
	   
	    Node result = new Node(0, 0);
	    while (!q.isEmpty()) {
	        Node cur = q.poll();
	        
	        if (result.cost < cur.cost) {
	            result = cur;
	        }
	        
	        for (Node nxt : graph[cur.idx]) {
	            if (visited[nxt.idx]) continue;
	            q.add(new Node(nxt.idx, cur.cost + nxt.cost));
	            visited[nxt.idx] = true;
	        }
	    }
	    
	    return result;
	}
}
