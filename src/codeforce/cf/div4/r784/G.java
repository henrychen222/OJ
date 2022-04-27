/**
 * 04/21/22 afternoon
 * https://codeforces.com/contest/1669/problem/G
 */
package codeforce.cf.div4.r784;

import java.util.*;
import java.io.*;

public class G {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1669/submission/154443319
    void solve(int n, int m, char[][] g) {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') {
//                    tr("start fall", i, j);
//                    outputGrid(g);
                    int row;
                    boolean swap = false;
                    for (row = i + 1; row < n; row++) {
                        if (g[row][j] != '.') {
                            if (row - 1 != i) {
                                g[row - 1][j] = '*';
                                g[i][j] = '.';
                                swap = true;
                            }
                            break;
                        }
                    }
//                    tr("after fall1", "row", row, swap);
//                    outputGrid(g);
                    if (row == n && !swap) {
                        if (g[row - 1][j] == '.') {
                            g[row - 1][j] = '*';
                            g[i][j] = '.';
                        }
                    }
//                    tr("after fall2");
//                    outputGrid(g);
                }
            }
        }
        // pr("");
        outputGrid(g);
    }

    void outputGrid(char[][] g) {
        for (char[] e : g) pr(new String(e));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            char[][] g = new char[n][];
            for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
            solve(n, m, g);
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
        new G().run();
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