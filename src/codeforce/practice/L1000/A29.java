/**
 * 11/03/21 night
 * https://codeforces.com/problemset/problem/29/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A29 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/29/134288034
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        Map<Integer, HashSet<Integer>> m = new HashMap<>();
        while (n-- > 0) {
            int x = fs.nextInt(), d = fs.nextInt();
            int t = x + d;
            if (!m.containsKey(t)) m.put(t, new HashSet<>());
            m.get(t).add(x);
        }
        // tr(m);
        for (int x : m.keySet()) {
            Set<Integer> sx = m.get(x);
            for (int spit : sx) {
                if (m.containsKey(spit)) {
                    Set<Integer> sy = m.get(spit);
                    if (sy.contains(x)) {
                        // tr(x, sy);
                        pr("YES");
                        return;
                    }
                }
            }
        }
        pr("NO");
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
        new A29().run();
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