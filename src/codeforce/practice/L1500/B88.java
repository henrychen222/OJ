/**
 * 04/13/26 morning
 * https://codeforces.com/problemset/problem/88/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B88 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/88/371053539
    void solve(int n, int m, int x, char[][] g, int q, char[] s) {
        Map<Character, Set<Character>> ma = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int a = 0; a < n; a++) {
                    for (int b = 0; b < m; b++) {
                        if (i != a || j != b) {
                            if (ok(i, j, a, b, x)) {
                                ma.computeIfAbsent(g[i][j], k -> new HashSet<>()).add(g[a][b]);
                            }
                        }
                    }
                }
            }
        }
//        tr(ma);
        int res = 0;
        for (char c : s) {
            if (!ma.containsKey(Character.toLowerCase(c))) {
                pr(-1);
                return;
            }
            if (Character.isUpperCase(c)) {
                if (!ma.containsKey('S')) {
                    pr(-1);
                    return;
                }
                var se = ma.get(Character.toLowerCase(c));
                if (!se.contains('S')) {
//                    tr(c, se);
                    res++;
                }
            }
        }
        pr(res);
    }

    boolean ok(int i, int j, int a, int b, int limit) {
        int disX = Math.abs(i - a), disY = Math.abs(j - b);
        return disX * disX + disY * disY <= limit * limit;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), x = fs.nextInt();
        char[][] g = new char[n][];
        for (int i = 0; i < n; i++) g[i] = fs.next().toCharArray();
        int q = fs.nextInt();
        char[] s = fs.next().toCharArray();
        solve(n, m, x, g, q, s);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B88().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ignored) {
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