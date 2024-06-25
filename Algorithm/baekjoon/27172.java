import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] x = new int[n];
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            tmp[i] = x[i];
        }

        Arrays.sort(tmp);
        int[] result = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            for (int j = 2 * tmp[i]; j <= tmp[n - 1]; j += tmp[i]) {
                int l = i + 1;
                int r = n - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (tmp[m] < j) {
                        l = m + 1;
                    } else if (tmp[m] > j) {
                        r = m - 1;
                    } else {
                        result[tmp[i]]++;
                        result[j]--;
                        break;
                    }
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(result[x[i]]).append(" ");
        }
        System.out.println(answer);
    }
}
