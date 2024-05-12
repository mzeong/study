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

        int[] increase = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            increase[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && increase[i] < increase[j] + 1) {
                    increase[i] = increase[j] + 1;
                }
            }
        }
        int[] decrease = new int[n + 2];
        for (int i = n; i >= 1; i--) {
            decrease[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j] && decrease[i] < decrease[j] + 1) {
                    decrease[i] = decrease[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, increase[i] + decrease[i]);
        }
        System.out.println(answer - 1);
    }
}
