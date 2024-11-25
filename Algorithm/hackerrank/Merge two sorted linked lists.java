import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            int m = Integer.parseInt(br.readLine());
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(br.readLine());
            }
            
            StringBuilder answer = new StringBuilder();
            int bIdx = 0;
            for (int aIdx = 0; aIdx < n; ) {
                if (bIdx >= m || a[aIdx] <= b[bIdx]) {
                    answer.append(a[aIdx]).append(" ");
                    aIdx++;
                } else {
                    answer.append(b[bIdx]).append(" ");
                    bIdx++;
                }
            }
            while (bIdx < m) {
                answer.append(b[bIdx]).append(" ");
                bIdx++;
            }
            
            System.out.println(answer);
        }
    }
}
