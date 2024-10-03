import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        Map<String, Boolean> playerInfo = new HashMap<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String result = st.nextToken();
            playerInfo.put(name, Objects.equals(result, "W"));
        }

        int score = 0;
        while (n-- > 0) {
            String name = br.readLine();

            if (playerInfo.containsKey(name) && playerInfo.get(name)) {
                score += w;
            } else {
                score = Math.max(score - l, 0);
            }

            if (score >= g) {
                System.out.println("I AM NOT IRONMAN!!");
                System.exit(0);
            }
        }
        System.out.println("I AM IRONMAN!!");
    }
}
