import java.io.*;
import java.util.*;

public class Main {

    private static final int COGS_COUNT = 4;
    private static final int TEETH_COUNT = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] cogWheels = new int[COGS_COUNT][TEETH_COUNT];
        for (int i = 0; i < COGS_COUNT; i++) {
            String cogWheel = br.readLine();
            for (int j = 0; j < TEETH_COUNT; j++) {
                cogWheels[i][j] = cogWheel.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        int[] cur = new int[]{0, 0, 0, 0};
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] nxt = Arrays.copyOf(cur, cur.length);
            nxt[num] = calc(cur[num], -dir);

            int l = num;
            while (--l >= 0) {
                int target = cogWheels[l][calc(cur[l], 2)];
                int prev = cogWheels[l + 1][calc(cur[l + 1], -2)];
                if (target == prev) {
                    break;
                }
                nxt[l] = calc(cur[l], l % 2 == num % 2 ? -dir : dir);
            }

            int r = num;
            while (++r < COGS_COUNT) {
                int target = cogWheels[r][calc(cur[r], -2)];
                int prev = cogWheels[r - 1][calc(cur[r - 1], 2)];
                if (target == prev) {
                    break;
                }
                nxt[r] = calc(cur[r], r % 2 == num % 2 ? -dir : dir);
            }

            cur = Arrays.copyOf(nxt, nxt.length);
        }

        int answer = 0;
        for (int i = 0, score = 1; i < COGS_COUNT; i++, score += score) {
            answer += cogWheels[i][cur[i]] * score;
        }
        System.out.println(answer);
    }

    private static int calc(int idx, int k) {
        return (idx + TEETH_COUNT + k) % TEETH_COUNT;
    }
}
