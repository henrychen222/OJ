/**
 * 12/24/21 morning
 * https://codeforces.com/contest/1615/problem/B
 */
package codeforce.global.r18;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    void solve(int l, int r) {
        int start = (int) Math.ceil(Math.log10(l) / Math.log10(2));
        int end = (int) Math.ceil(Math.log10(r) / Math.log10(2));
//        int[] bit = new int[32];
//        int pre = 1 << start;
//        for (int i = start; i <= end; i++) {
//            int x = 1 << i;
//            bit[i] = x - pre;
//            pre = x;
//        }
//        tr(start, end, bit, bit[end], bit[end] - l);
        int diffR = r - (1 << end - 1);
        // tr(l, r, diffR);
        // int res = Math.abs(l - diffR);
        int res = (1 << end) - (1 << start) - l;
        pr(res);
    }

    void solve2(int l, int r) {
        int tot = r - l + 1;
        int lmax = Integer.highestOneBit(l), rmax = Integer.highestOneBit(r);
        String ls = generate32String(l), rs = generate32String(r);
        tr(l, lmax, ls);
        tr(r, rmax, rs);
        int res = rmax - tot + 1;
        pr(res);
    }

    // TLE
    void solve1(int l, int r) {
        int tot = r - l + 1;
        int[] bit = new int[32];
        for (int x = l; x <= r; x++) {
            String s = generate32String(x);
            for (int i = 0; i < 32; i++) {
                if (s.charAt(i) == '1') bit[i]++;
            }
            // tr(x, s);
        }
        int max = 0;
        for (int x : bit) max = Math.max(x, max);
        tr(bit, "max", max, r - l >> 1);
        pr(tot - max);
    }

    String generate32String(int x) {
        String s = Integer.toBinaryString(x);
        int n = s.length();
        String rest = "0".repeat(32 - n);
        return rest + s;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new B().run();
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