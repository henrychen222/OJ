/**
 * 09/05/22 night
 * https://codeforces.com/problemset/problem/146/B
 */
package codeforce.practice.L1300;

import java.util.*;
import java.io.*;

public class B146 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/146/171017376
    // 77777 77777
    void solve(int a, int b) {
        for (int c = a + 1; ; c++) {
            if (mask(c) == b) {
                pr(c);
                return;
            }
        }
    }

    int mask(int x) {
        String s = x + "", res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '4' || c == '7') res += c;
        }
        return res.length() == 0 ? 0 : Integer.parseInt(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(2);
        solve(a[0], a[1]);
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
        new B146().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}