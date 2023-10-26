import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        String[] secondLine = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(secondLine[i]);
        }

        int answer = 0;
        int cnt = 0;
        int l = 0;
        int r = 0;
        while (l < n) {
            while (r < n && (isEven(arr[r]) || cnt < k)) {
                if (isOdd(arr[r])) cnt++;
                r++;
            }
            answer = max(answer, r - l - cnt);
            if (isOdd(arr[l])) cnt--;
            l++;
        }
        System.out.println(answer);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
