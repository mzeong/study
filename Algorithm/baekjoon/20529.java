import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n > 32) {
                br.readLine();
                System.out.println(0);
            } else {
                int answer = 10;

                String[] input = new String[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    input[i] = st.nextToken();
                }

                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        for (int k = j + 1; k < n; k++) {
                            String first = input[i];
                            String second = input[j];
                            String third = input[k];

                            answer = Math.min(answer, sol(first, second) + sol(second, third) + sol(first, third));
                        }
                    }
                }
                System.out.println(answer);
            }
        }
    }

    private static int sol(String a, String b) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                result++;
            }
        }
        return result;
    }
}
