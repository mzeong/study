import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Queue<Integer> q = new LinkedList<>();

        int query = Integer.parseInt(br.readLine());
        while (query-- > 0) {
            String[] input = br.readLine().split(" ");
            
            if (input[0].equals("1")) {
                String x = input[1];
                q.add(Integer.parseInt(x));    
            } else if (input[0].equals("2")) {
                q.remove();
            } else if (input[0].equals("3")) {
                System.out.println(q.element());
            }
        }
    }
}
