/**
 * 09/28/21 morning  09/29/21 evening complete
 * https://codeforces.com/contest/1579/problem/C
 */

package codeforce.cf.div3.r744;

import java.util.*;
import java.io.*;

public class C {

    static PrintWriter pw;

    int n, m, k;
    char[][] g;

    // Accepted --- https://codeforces.com/contest/1579/submission/130307470
    // reference Tlatoani
    void solve() {
        boolean[][] visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') {
                    int edge = 0;
                    while (i - edge >= 0 && j - edge >= 0 && j + edge < m
                            && g[i - edge][j - edge] != '.' && g[i - edge][j + edge] != '.') edge++;
                    edge--;
                    if (edge >= k) {
                        for (int l = 0; l <= edge; l++) {
                            visit[i - l][j - l] = true;
                            visit[i - l][j + l] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*' && !visit[i][j]) {
                    pr("NO");
                    return;
                }
            }
        }
        pr("YES");
    }

    /////////////////////////////////////////////////////////////////////////
    // wrong
    void solve1() {
        // tr(n, m, k, g);
        int minEdge = k + 1;
        int[][] center = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '*') {
                    // tr("need", i, j);
                    if (center[i][j] == 1) continue;
                    boolean found = false;
                    for (int edge = minEdge; ; edge++) {
                        int plus = edge - 1;
                        int cx = i + plus, cy = j + plus;
                        int rx = i, ry = j + 2 * plus;
                        if (!inside(cx, cy) && !inside(rx, ry)) break;
                        // tr("center", cx, cy, "right", rx, ry);
                        if (inside(cx, cy) && inside(rx, ry)) {
                            center[cx][cy] = 1;
                            found = true;
                            break;
                        }
                    }
                    if (found) continue;
                    for (int edge = minEdge; ; edge++) { // find left
                        int plus = edge - 1;
                        int cx = i + plus, cy = j - plus;
                        int lx = i, ly = j - 2 * plus;
                        if (!inside(cx, cy) && !inside(lx, ly)) break;
                        // tr("center", cx, cy, "left", lx, ly);
                        if (inside(cx, cy) && inside(lx, ly)) {
                            center[cx][cy] = 1;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        pr("NO");
                        return;
                    }
                }
            }
        }
        pr("YES");
    }

    boolean inside(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            m = fs.nextInt();
            k = fs.nextInt();
            g = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = fs.next();
                g[i] = s.toCharArray();
            }
            solve();
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
        new C().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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