/**
 * 04/17/23 night 04/19/23 night complete
 * https://codeforces.com/problemset/problem/614/B
 */
package codeforce.practice.L1400;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class B614 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/614/202791828
    // reference: https://codeforces.com/contest/614/standings/friends/true ecnerwala
    void solve(int n, String[] a) {
        int cnt = 0;
        String res = "1";
        for (String s : a) {
            if (s.equals("0")) {
                pr(0);
                return;
            }
            boolean ok = s.charAt(0) == '1';
            for (int i = 1; i < s.length(); i++) ok = ok && (s.charAt(i) == '0');
            if (ok) {
                cnt += s.length() - 1;
            } else {
                res = s;
            }
        }
        res += "0".repeat(cnt);
        pr(res);
    }

    // TLE
    void solve1(int n, String[] a) {
        BigInteger p = BigInteger.ONE;
        for (String x : a) {
            if (x.charAt(0) == '0') {
                pr(0);
                return;
            }
            p = p.multiply(new BigInteger(x));
        }
        pr(p);
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String[] a = fs.nextLine().split(" ");
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B614().run();
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

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}