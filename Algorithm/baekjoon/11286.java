import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>();
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (positive.isEmpty() && negative.isEmpty()) {
                    System.out.println(0);
                } else if (positive.isEmpty()) {
                    System.out.println(negative.poll() * -1);
                } else if (negative.isEmpty()) {
                    System.out.println(positive.poll());
                } else {
                    if (negative.peek() <= positive.peek()) {
                        System.out.println(negative.poll() * -1);
                    } else {
                        System.out.println(positive.poll());
                    }
                }
            } else if (x < 0) {
                negative.add(x * -1);
            } else {
                positive.add(x);
            }
        }
    }
}
