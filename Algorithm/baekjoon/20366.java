import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
		    h[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(h);
		
		int answer = 1_000_000_000;
		for (int i = 0; i < n; i++) {
		    for (int j = i + 1; j < n; j++) {
		        int l = 0, r = n - 1;
		        int s1 = h[i] + h[j];
		        
		        while (l < r) {
		            int s2 = h[l] + h[r];
		            if (l != i && l != j && r != i && r != j) {
    		            int tmp = Math.abs(s1 - s2);
    		            if (tmp < answer) {
    		                answer = tmp;
    		            }
		            }
		            
		            if (s2 < s1) l++;
		            else r--;
		        }
		    }
		}
		System.out.println(answer);
	}
}
