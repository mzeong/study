import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] exist = new int[100001];
        int answer = 0;
        int s = 0;
        int e = 0;
        while (s < n) {
            while (e < n && exist[arr[e]] < k) {
                exist[arr[e]]++;
                e++;
            }
            answer = Math.max(answer, e - s);
            exist[arr[s]]--;
            s++;
        }
        System.out.println(answer);
    }
}
