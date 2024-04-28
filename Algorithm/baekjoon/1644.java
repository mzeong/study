// 풀이 2
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    int[] a = new int[n + 1];
	    for (int i = 2; i <= n; i++) a[i] = i;
	    for (int i = 2; i <= n; i++) {
	        if (a[i] == 0) continue;
	        for (int j = i * 2; j <= n; j += i) {
	            a[j] = 0;
	        }
	    }
	    List<Integer> p = new ArrayList<>();
	    for (int i = 2; i <= n; i++) {
	        if (a[i] == 0) continue;
	        p.add(i);
	    }
	    
	    int answer = 0;
	    int l = 0, r = 0, sum = 0;
	    while (true) {
	        if (sum >= n) sum -= p.get(l++);
	        else if (r == p.size()) break;
	        else sum += p.get(r++);
	        
	        if (sum == n) answer++;
	    }
	    System.out.println(answer);
	}
}

// 풀이 1
import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    if (n == 1) { // N이 1부터 주어짐, 처리 안 해주면 런타임 에러 (IndexOutOfBounds)
	        System.out.println(0);
	        System.exit(0);
	    }
	    
	    int[] a = new int[n + 1];
	    for (int i = 2; i <= n; i++) a[i] = i;
	    for (int i = 2; i <= n; i++) {
	        if (a[i] == 0) continue;
	        for (int j = i * 2; j <= n; j += i) {
	            a[j] = 0;
	        }
	    }
	    List<Integer> p = new ArrayList<>();
	    for (int i = 2; i <= n; i++) {
	        if (a[i] == 0) continue;
	        p.add(i);
	    }
	    
	    int l = 0, r = 0;
	    int sum = p.get(l);
	    int answer = 0;
	    while (l <= r) {
	        while (sum < n) {
	            if (r == p.size() - 1) break; 
	            r++;
	            sum += p.get(r);
	        }
	        
	        if (sum == n) {
	            answer++;
	        }
	       
	        sum -= p.get(l);
	        l++;
	    }
	    System.out.println(answer);
	}
}
