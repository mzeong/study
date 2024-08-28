import java.io.*;

public class Main {

    private static int n;
    private static String exp;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        exp = br.readLine();

        answer = Integer.MIN_VALUE;
        sol(0, exp.charAt(0) - '0');
        
        System.out.println(answer);
    }

    private static void sol(int idx, int val) {
        if (idx == n - 1) {
            answer = Math.max(answer, val);
            return;
        }

        if (idx + 4 < n) {
            int rst = cal(exp.charAt(idx + 3), exp.charAt(idx + 2) - '0', exp.charAt(idx + 4) - '0');
            sol(idx + 4, cal(exp.charAt(idx + 1), val, rst));
        }
        sol(idx + 2, cal(exp.charAt(idx + 1), val, exp.charAt(idx + 2) - '0'));
    }

    private static int cal(char op, int a, int b) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        }
        return a * b;
    }
}
