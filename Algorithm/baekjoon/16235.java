import java.io.*;
import java.util.*;

public class Main {

    private static int[][] arr;
    private static List<Tree>[][] trees;
    private static int[][] a;
    private static int n;
    private static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        a = new int[n + 1][n + 1];
        for (int r = 1; r <= n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= n; c++) {
                a[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        trees = new ArrayList[n + 1][n + 1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                trees[r][c] = new ArrayList<>();
            }
        }
        for (int r = 1; r <= m; r++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees[x][y].add(new Tree(z, false));
        }

        arr = new int[n + 1][n + 1];
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                arr[r][c] = 5;
            }
        }
        while (k-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }
        int answer = 0;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                answer += trees[r][c].size();
            }
        }
        System.out.println(answer);
    }

    private static void spring() {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                List<Tree> tree = trees[r][c];
                Collections.sort(tree);
                for (Tree t : tree) {
                    if (arr[r][c] - t.age >= 0) {
                        arr[r][c] -= t.age;
                        t.age++;
                    } else {
                        t.die = true;
                    }
                }
            }
        }
    }

    private static void summer() {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                List<Tree> tree = trees[r][c];
                List<Tree> tmp = new ArrayList<>();
                for (Tree t : tree) {
                    if (t.die) {
                        arr[r][c] += t.age / 2;
                    } else {
                        tmp.add(t);
                    }
                }
                trees[r][c] = tmp;
            }
        }
    }

    private static void fall() {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                List<Tree> tree = trees[r][c];
                for (Tree t : tree) {
                    if (t.die || t.age % 5 != 0) {
                        continue;
                    }
                    for (int i = 0; i < 8; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (nr <= 0 || nr > n || nc <= 0 || nc > n) {
                            continue;
                        }
                        trees[nr][nc].add(new Tree(1, false));
                    }
                }
            }
        }
    }

    private static void winter() {
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                arr[r][c] += a[r][c];
            }
        }
    }

    static class Tree implements Comparable<Tree> {

        int age;
        boolean die;

        public Tree(int age, boolean die) {
            this.age = age;
            this.die = die;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
