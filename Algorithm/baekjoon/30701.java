import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Long.parseLong(st.nextToken());

        List<Integer> monsters = new ArrayList<>();
        List<Integer> equipment = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (a == 1) {
                monsters.add(x);
            } else {
                equipment.add(x);
            }
        }

        Collections.sort(monsters);
        Collections.sort(equipment);

        int answer = 0;
        int idx = 0;
        for (int monster : monsters) {
            while (d <= monster && idx < equipment.size()) {
                d *= equipment.get(idx++);
                answer++;
            }
            if (d > monster) {
                d += monster;
                answer++;
            } else {
                break;
            }
        }
        while (idx < equipment.size()) {
            d *= equipment.get(idx++);
            answer++;
        }
        System.out.println(answer);
    }
}
