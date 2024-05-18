import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] brokenButton = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int k = Integer.parseInt(st.nextToken());
                brokenButton[k] = true;
            }
        }

        int answer = Math.abs(n - 100);
        for (int channel = 0; channel < 1_000_000; channel++) {
            boolean flag = true;
            int j = channel;
            do {
                if (brokenButton[j % 10]) {
                    flag = false;
                    break;
                }
                j /= 10;
            } while (j > 0);

            if (flag) {
                int tmp = Math.abs(channel - n) + String.valueOf(channel).length();
                answer = Math.min(answer, tmp);
            }
        }

        System.out.println(answer);
    }
}
