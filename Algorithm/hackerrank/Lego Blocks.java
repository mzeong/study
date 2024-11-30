import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */
    private static final int MOD = 1_000_000_007;
    
    public static int legoBlocks(int n, int m) {    
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            dp[i] = dp[i - 1];
            for (int k = 2; k <= 4; k++) {
                if (i - k >= 0) {
                    dp[i] += dp[i - k];
                    dp[i] %= MOD;
                }
            }
        }

        int[] comb = new int[m + 1];
        BigInteger exp = BigInteger.valueOf(n);
        BigInteger mod = BigInteger.valueOf(MOD);
        for (int i = 0; i <= m; i++) {
            BigInteger base = BigInteger.valueOf(dp[i]);
            comb[i] = base.modPow(exp, mod).intValue();
        }
        
        int[] results = new int[m + 1];
        results[0] = 1;
        for (int i = 1; i <= m; i++) {
            int unstable = 0;
            for (int j = 1; j < i; j++) {
                unstable += (1L * results[j] * comb[i - j]) % MOD;
                unstable %= MOD;
            }
            results[i] = (comb[i] - unstable + MOD) % MOD;
        }
        
        return results[m];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
