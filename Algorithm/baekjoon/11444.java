import java.io.*;
import java.util.*;

public class Main {

    private static final int MOD = 1_000_000_007;

    private static final Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());

        System.out.println(f(n));
    }

    private static long f(long n) {
        if (n < 2) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        if (n % 2 == 0) {
            memo.put(n, (f(n / 2) * (2 * f(n / 2 - 1) + f(n / 2))) % MOD);
        } else {
            memo.put(n, (f((n + 1) / 2) * f((n + 1) / 2) + f((n - 1) / 2) * f((n - 1) / 2)) % MOD);
        }
        return memo.get(n);
    }
}
