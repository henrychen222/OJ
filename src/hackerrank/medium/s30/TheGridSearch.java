/**
 * 12/12/22 night
 * https://www.hackerrank.com/challenges/the-grid-search
 */
package hackerrank.medium.s30;

import java.util.*;
import java.io.*;

public class TheGridSearch {
    static PrintWriter pw;

    // Accepted
    void solve(int R, int C, char[][] G, int r, int c, char[][] g) {
        for (int i = 0; i + r - 1 < R; i++) {
            for (int j = 0; j + c - 1 < C; j++) {
                boolean ok = true;
                for (int k = 0; k < r; k++) {
                    for (int m = 0; m < c; m++) {
                        if (g[k][m] != G[i + k][j + m]) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) {
                    pr("YES");
                    return;
                }
            }
        }
        pr("NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int R = fs.nextInt(), C = fs.nextInt();
            char[][] G = new char[R][];
            for (int i = 0; i < R; i++) G[i] = fs.next().toCharArray();
            int r = fs.nextInt(), c = fs.nextInt();
            char[][] g = new char[r][];
            for (int i = 0; i < r; i++) g[i] = fs.next().toCharArray();
            solve(R, C, G, r, c, g);
        }
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
        new TheGridSearch().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
