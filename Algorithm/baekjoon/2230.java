import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int e = 0;
        int answer = 1_000_000_000 * 2;
        for (int s = 0; s < n; s++) {
            while (e < n && arr[e] - arr[s] < m) e++;
            if (e == n) break;
            answer = Math.min(answer, arr[e] - arr[s]);
        }
        System.out.println(answer);
    }
}
