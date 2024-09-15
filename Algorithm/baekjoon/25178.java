import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String word1 = br.readLine();
        String word2 = br.readLine();

        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            int idx1 = word1.charAt(i) - 'a';
            int idx2 = word2.charAt(i) - 'a';
            alphabet[idx1]++;
            alphabet[idx2]--;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        if (word1.charAt(0) != word2.charAt(0) || word1.charAt(n - 1) != word2.charAt(n - 1)) {
            System.out.println("NO");
            System.exit(0);
        }

        for (int i = 0, j = 0; i < n; i++) {
            char ch1 = word1.charAt(i);

            if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
                continue;
            }
            char ch2 = word2.charAt(j++);
            while (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                ch2 = word2.charAt(j++);
            }
            if (ch1 != ch2) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
}
