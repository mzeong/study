import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (b > a) {
            b = b % 10 == 1 ? b / 10 : b % 2 == 0 ? b / 2 : -1;
            answer++;
        }

        System.out.println(b == a ? answer + 1 : -1);
    }
}
