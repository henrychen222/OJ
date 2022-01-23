/**
 * 01/10/22 afternoon
 * https://codeforces.com/contest/1624/problem/E
 */
package codeforce.cf.div3.r764;

import java.util.*;
import java.io.*;

public class E {
    static PrintWriter pw;
    int[][] tar = new int[1010][4];
    int[][] pos = new int[1010][4];
    int[] from = new int[1010];

    // Accepted --- https://codeforces.com/contest/1624/submission/142308284
    // reference: kmjp
    void solve(int n, int m, char[][] g, String s) {
        // tr(n, m, g, s);
        for (int[] a : tar) Arrays.fill(a, -1);
        for (int[] a : pos) Arrays.fill(a, -1);
        for (int y = 0; y < n; y++) {
            for (int len = 2; len <= 3; len++) {
                for (int x = 0; x + len <= m; x++) {
                    int v = 0;
                    for (int i = 0; i < len; i++) {
                        v = v * 10 + g[y][x + i] - '0';
                    }
                    tar[v][len] = y + 1;
                    pos[v][len] = x + 1;
                }
            }
        }
        Arrays.fill(from, -1);
        from[0] = 0;
        for (int x = 0; x < m; x++) {
            if (from[x] >= 0) {
                for (int len = 2; len <= 3; len++) {
                    if (x + len > m) continue;
                    int v = 0;
                    for (int i = 0; i < len; i++) {
                        v = v * 10 + s.charAt(x + i) - '0';
                    }
                    if (tar[v][len] >= 0) {
                        from[x + len] = len * 1000 + v;
                    }
                }
            }
        }
        // tr(from[m]);
        if (from[m] >= 0) {
            List<int[]> res = new ArrayList<>();
            int cur = m;
            while (cur > 0) {
                int x = from[cur] / 1000;
                int y = from[cur] % 1000;
                res.add(new int[]{tar[y][x], pos[y][x], pos[y][x] + x - 1});
                cur -= x;
            }
            // debugArrayInList(res);
            res = reverse(res);
            // debugArrayInList(res);
            pr(res.size());
            for (int[] a : res) {
                pr(a[1] + " " + a[2] + " " + a[0]);
            }
        } else {
            pr(-1);
        }
    }

    void debugArrayInList(List<int[]> l) {
        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    List<int[]> reverse(List<int[]> l) {
        List<int[]> res = new ArrayList<>();
        for (int i = l.size() - 1; i >= 0; i--) res.add(l.get(i));
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), m = fs.nextInt();
            char[][] g = new char[n][];
            for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
            String s = fs.next();
            solve(n, m, g, s);
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
        new E().run();
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