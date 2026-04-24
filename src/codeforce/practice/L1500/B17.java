/**
 * 04/13/26 afternoon
 * https://codeforces.com/problemset/problem/17/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B17 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/17/371063548
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] q = fs.readArray(n);
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) a[i] = new int[]{q[i], i + 1};
        Arrays.sort(a, Comparator.comparingInt(x -> -x[0]));
        int m = fs.nextInt();
        Map<Integer, TreeSet<Integer>> ma = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] e = fs.readArray(3);
            ma.computeIfAbsent(e[1], k -> new TreeSet<>()).add(e[2]);
        }
        // tr(ma, a);
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (!ma.containsKey(a[i][1])) {
                pr(-1);
                return;
            }
            res += ma.get(a[i][1]).first();
        }
        pr(res);
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
        new B17().run();
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