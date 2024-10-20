import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int[] types = new int[10];
        int typeCount = 0;
        for (int l = 0, r = 0; r < n; r++) {
            if (types[s[r]] == 0) {
                typeCount++;
            }
            types[s[r]]++;

            if (typeCount > 2) {
                if (types[s[l]] == 1) {
                    typeCount--;
                }
                types[s[l]]--;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }
        System.out.println(result);


    }
}
