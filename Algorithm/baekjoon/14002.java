import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

        Stack<Integer> s = new Stack<>();
        for (int i = n; i > 0; i--) {
            if (answer == dp[i]) {
                s.push(arr[i]);
                answer--;
            }
        }
        StringBuilder result = new StringBuilder();
        while (!s.isEmpty()) {
            result.append(s.pop()).append(" ");
        }
        System.out.println(result);
    }
}
