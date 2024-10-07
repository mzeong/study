import java.io.*;
import java.util.*;

public class Main {

    private static final int[] aw = {508, 108};
    private static final int[] bw = {212, 305};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());

        if (s % 4763 != 0) {
            System.out.println(0);
            System.exit(0);
        }
        s /= 4763;

        if (s == 0) {
            System.out.println("1");
            System.out.println("0 0");
            System.exit(0);
        }
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int a = 0; a <= 200; a++) {
            for (int b = 0; b <= 200; b++) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (a * aw[i] + b * bw[j] == s) {
                            aList.add(a);
                            bList.add(b);
                        }
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(aList.size()).append("\n");
        for (int i = 0; i < aList.size(); i++) {
            answer.append(aList.get(i)).append(" ");
            answer.append(bList.get(i)).append("\n");
        }
        System.out.println(answer);
    }
}
