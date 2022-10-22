/**
 * 05/04/22 afternoon
 * https://codeforces.com/problemset/problem/381/B
 */
package codeforce.practice.L1100;

import java.util.*;
import java.io.*;

public class B381 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/381/155877951
    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> m = counter(a);
        Deque<Integer> d = new ArrayDeque<>();
        for (int x : m.keySet()) {
            int occ = m.get(x);
            if (occ == 1 || d.size() == 0) {
                d.add(x);
            } else {
                d.addFirst(x);
                d.add(x);
            }
        }
        pr(d.size());
        outputD(d);
    }

    void outputD(Deque<Integer> deque) {
        for (int e : deque) pw.print(e + " ");
        pr("");
    }

    TreeMap<Integer, Integer> counter(int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new B381().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}