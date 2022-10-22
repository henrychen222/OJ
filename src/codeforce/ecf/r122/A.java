/**
 * 02/22/22 evening
 * https://codeforces.com/contest/1633/problem/A
 */
package codeforce.ecf.r122;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;
    TreeSet<Integer> ts;

    // Accepted --- https://codeforces.com/contest/1633/submission/147379023
    void solve(int n) {
        String s = n + "";
        int l = ts.floor(n);
        String sl = l + "";
        if (sl.length() == s.length()) {
            if (changeDigit(s, sl) == 1) { // case 20
                pr(l);
                return;
            }
        }
        int r = ts.ceiling(n);
        pr(r);
    }

    int changeDigit(String s, String sl) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sl.charAt(i)) cnt++;
        }
        return cnt;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        ts = new TreeSet<>();
        for (int i = 1; i * 7 < 1000; i++) ts.add(7 * i);
        // tr(ts);
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new A().run();
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}