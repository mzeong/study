import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + k];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < k; i++) {
            arr[n + i] = arr[i];
        }

        int[] exist = new int[d + 1];
        int answer = 0;
        int s = 0;
        int e = 0;
        int dup = 0;
        boolean couponSushi = false;
        while (s < n) {
            while (e < arr.length && e - s < k) {
                if (exist[arr[e]] > 0) dup++;
                exist[arr[e]]++;
                e++;
            }
            if (answer < e - s - dup) {
                answer = e - s - dup;
                couponSushi = (exist[c] > 0);
            } else if (answer == e - s - dup && couponSushi && exist[c] == 0) {
                couponSushi = false;
            }
            if (exist[arr[s]] > 1) dup--;
            exist[arr[s]]--;
            s++;
        }
        if (!couponSushi) answer++;
        System.out.println(answer);
    }
}
