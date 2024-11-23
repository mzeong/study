import java.io.*;
import java.util.*;

public class Main {

    private static final int ALPHABET_CNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] s = br.readLine().toCharArray();

        for (int i = 0; i < n && k > 0; i++) {
            int idx = s[i] - 'A';
            int toA = (ALPHABET_CNT - idx) % ALPHABET_CNT;

            if (toA <= k) {
                s[i] = 'A';
                k -= toA;
            }
        }
        if (k > 0) {
            int idx = s[n - 1] - 'A';
            s[n - 1] = (char) ('A' + (idx + k) % ALPHABET_CNT);
        }

        System.out.println(new String(s));
    }
}
/*
3 26
AZB

answer: AAA
 */
