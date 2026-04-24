/**
 * 04/13/26 afternoon
 * https://codeforces.com/problemset/problem/49/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B49 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/49/371062357
    void solve(String a, String b) {
        int res = 0;
        int minBase = 0;
        for (char c : (a + b).toCharArray()) minBase = Math.max(minBase, c - '0');
        for (int i = minBase + 1; i <= 100; i++) {
            long va = AnyBaseToDecimal(a, i);
            long vb = AnyBaseToDecimal(b, i);
            long sum = va + vb;
            String s = DecimalToAnyBase(sum, i);
//            tr(va, vb, sum, i, s);
            res = Math.max(res, s.length());
        }
        pr(res);
    }

    long AnyBaseToDecimal(String s, int base) {
        int n = s.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            res = res * base + d;
        }
        return res;
    }

    String d = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String DecimalToAnyBase(long x, int ToBase) { // max base depends on d, base can be negative
//        if (ToBase <= 1) return "?"; // Invalid base
        StringBuilder res = new StringBuilder();
        while (x != 0) {
            long rem = x % ToBase;
            x /= ToBase;
            if (rem < 0) {
                rem += Math.abs(ToBase);
                x++;
            }
            res.insert(0, d.charAt((int) rem));
        }
        return res.toString();
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        solve(fs.next(), fs.next());
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
        new B49().run();
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