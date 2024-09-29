import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] l = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(l);
        
        int answer = 0;
        int left = 1, right = l[n];
        while (left <= right) {
            int mid = (left + right) / 2;

            int result = 0;
            for (int i = 1; i <= n; i++) {
                result += l[i] / mid;
            }

            if (result < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }
}
