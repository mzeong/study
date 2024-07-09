import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n < 8) {
            System.out.println(-1);
        } else {
            int a = 2;
            int b = (n % 2 == 0) ? 2 : 3;
            int m = n - a - b;

            boolean[] isPrime = new boolean[m + 1];
            for (int i = 2; i <= m; i++) {
                isPrime[i] = true;
            }
            for (int i = 2; i * i <= m; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= m; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            int c = 0, d = 0;
            for (int i = 2; i <= m / 2; i++) {
                if (isPrime[i] && isPrime[m - i]) {
                    c = i;
                    d = n - a - b - i;
                    break;
                }
            }
            System.out.println(String.format("%d %d %d %d", a, b, c, d));
        }
    }
}
// 골드바흐의 추측: 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다.
