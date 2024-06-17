import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int[][] dp = new int[1001][1001];
		
		for (int i = 1; i <= str1.length(); i++) {
		    for (int j = 1; j <= str2.length(); j++) {
		        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
		            dp[i][j] = dp[i - 1][j - 1] + 1;
		        } else {
		            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		        }
		    }
		}
		
		int answer1 = dp[str1.length()][str2.length()];
		System.out.println(answer1);
		
		if (answer1 > 0) {
		    Stack<Character> s = new Stack<>();
    		int i = str1.length();
    		int j = str2.length();
    		do {
    		    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
        		    s.push(str1.charAt(i - 1));
        		    i--;
        		    j--;
        		} else {
        		    if (dp[i][j - 1] > dp[i - 1][j]) {
        		        j--;
        		    } else {
        		        i--;
        		    }
        		}
    		} while (i > 0 && j > 0);
    		
    		StringBuilder answer2 = new StringBuilder();
    		while (!s.isEmpty()) {
    		    answer2.append(s.pop());
    		}
    		System.out.println(answer2);
    	}
	} 
}
