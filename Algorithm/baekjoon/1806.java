import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = N + 1;
		int e = 0, sum = arr[0];
		for (int s = 0; s < N; s++) {
		    while (e < N && sum < S) {
		        e++;
		        if (e != N) sum += arr[e];
		    }
		    if (e == N) break;
		    answer = Math.min(answer, e - s + 1);
		    sum -= arr[s];
		}
		
		if (answer == N + 1) answer = 0;
	    System.out.println(answer);
	}
}
