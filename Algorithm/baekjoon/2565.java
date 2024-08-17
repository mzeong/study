import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        List<Wire> wires = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            wires.add(new Wire(a, b));
        }

        Collections.sort(wires);

        int[] dp = new int[k];
        int result = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < i; j++) {
                if (wires.get(j).b < wires.get(i).b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i] + 1);
        }

        System.out.println(k - result);
    }

    private static class Wire implements Comparable<Wire> {

        int a;
        int b;

        public Wire(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Wire other) {
            return this.a - other.a;
        }
    }
}
