import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int answer = 0;
        boolean rhombus = false;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (Character.isUpperCase(cur) && rhombus || Character.isLowerCase(cur) && !rhombus) {
                answer++;
            } else {
                if (i + 1 < input.length() && isSameCase(cur, input.charAt(i + 1))) {
                    rhombus = !rhombus;
                }
                answer += 2;
            }
        }
        System.out.println(answer);
    }

    private static boolean isSameCase(char ch1, char ch2) {
        return Character.isUpperCase(ch1) && Character.isUpperCase(ch2) ||
                Character.isLowerCase(ch1) && Character.isLowerCase(ch2);
    }
}
