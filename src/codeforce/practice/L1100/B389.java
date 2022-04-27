/**
 * 02/16/22 afternoon
 * https://codeforces.com/problemset/problem/389/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B389 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/389/146676193
    void solve(int n, char[][] g) {
        int cnt = 0, center = 0;
        boolean[][] visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == '#') {
                    cnt++;
                    if ((i - 1 >= 0 && g[i - 1][j] == '#' && !visit[i - 1][j]) && (i + 1 < n && g[i + 1][j] == '#' && !visit[i + 1][j])
                            && (j - 1 >= 0 && g[i][j - 1] == '#' && !visit[i][j - 1]) && (j + 1 < n && g[i][j + 1] == '#' && !visit[i][j + 1])) {
                        // tr(i + 1, j + 1);
                        center++;
                        visit[i][j] = true;
                        visit[i - 1][j] = true;
                        visit[i + 1][j] = true;
                        visit[i][j - 1] = true;
                        visit[i][j + 1] = true;
                    }
                }
            }
        }
        // tr(cnt, center);
        if (cnt % 5 == 0 && cnt / 5 == center) {
            pr("YES");
        } else {
            pr("NO");
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        solve(n, g);
    }

    private final String INPUT = "input.txt";
    private final String OUTPUT = "output.txt";

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B389().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

