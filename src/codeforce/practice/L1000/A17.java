/**
 * 11/02/21 night
 * https://codeforces.com/problemset/problem/17/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A17 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/17/134176358
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        TreeSet<Integer> se = sieveEratosthenes(1000);
        int n = fs.nextInt(), k = fs.nextInt();
        List<Integer> a = new ArrayList<>(se);
        List<Integer> n2data = new ArrayList<>();
        for (int x : se) {
            if (x > n) break;
            n2data.add(x);
        }
        // tr(a);
        TreeSet<Integer> express = new TreeSet<>();
        for (int i = 1; i < a.size(); i++) {
            int x = a.get(i - 1) + a.get(i) + 1;
            if (se.contains(x)) express.add(x);
        }
        // tr(express);
        int cnt = 0;
        for (int x: n2data) {
            if (express.contains(x)) cnt++;
        }
        // tr(cnt);
        pr(cnt >= k ? "YES" : "NO");
    }

    TreeSet<Integer> sieveEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        TreeSet<Integer> se = new TreeSet<>();
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (!prime[p]) continue;
            for (int i = p * p; i <= n; i += p) prime[i] = false;
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) se.add(i);
        }
        return se;
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
        new A17().run();
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