import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(h);

        int answer = 0;
        int[] tmp = new int[c];
        for (int i = 0; i < n && answer / c < r; i++) {
            if (tmp[answer % c] < h[i]) {
                tmp[answer % c] = h[i];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
