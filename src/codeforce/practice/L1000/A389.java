/**
 * 11/02/21 night
 * https://codeforces.com/problemset/problem/389/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A389 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/389/134165825
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        TreeMap<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        while (m.size() > 1) {
            // tr(m);
            int max = m.firstKey();
            operate(m, max);
            // tr("after", m);
            int smax = m.firstKey();
            if (smax == max) {
                for (int k : m.keySet()) {
                    if (k != max) {
                        smax = k;
                        break;
                    }
                }
            }
            // tr(max, smax);
            int add = max - smax;
            if (add > 0) m.put(add, m.getOrDefault(add, 0) + 1);
        }
        // tr(m);
        pr(m.firstKey() * m.firstEntry().getValue());
    }

    void operate(TreeMap<Integer, Integer> m, Integer k) {
        int occ = m.get(k);
        if (occ <= 1) {
            m.remove(k);
        } else {
            m.put(k, occ - 1);
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
        new A389().run();
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