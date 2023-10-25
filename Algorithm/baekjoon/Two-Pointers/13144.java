import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] exist = new boolean[100001];
        long answer = 0;
        int l = 0;
        int r = 0;
        while (l < n) {
            while (r < n && !exist[sequence[r]]) {
                exist[sequence[r]] = true;
                r++;
            }
            answer += r - l;
            exist[sequence[l]] = false;
            l++;
        }
        System.out.println(answer);
    }
}
