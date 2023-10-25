/**
 * 11/18/22 night
 * https://codeforces.com/problemset/problem/174/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B174 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/174/181385539
    void solve(String ss) {
        if (ss.length() == 1 || ss.charAt(ss.length() - 1) == '.' || ss.charAt(0) == '.') { // .  .a  a. z
            pr("NO");
            return;
        }
        for (int i = 1; i < ss.length(); i++) {
            if (ss.charAt(i - 1) == '.' && ss.charAt(i) == '.') {
                pr("NO");
                return;
            }
        }
        String[] a = ss.split("\\.");
        if (a.length == 1) { // za
            pr("NO");
            return;
        }
        if (a[0].length() > 8 || a[a.length - 1].length() > 3) {
            pr("NO");
            return;
        }
        List<String> res = new ArrayList<>();
        res.add(a[0]);
        for (int i = 1; i + 1 < a.length; i++) {
            String s = a[i];
            if (s.length() > 11 || s.length() < 2) { // a.b.c
                pr("NO");
                return;
            }
            String l = "", r = "";
            if (s.length() > 3) {
                l += s.substring(0, 3);
                r += s.substring(3);
            } else {
                l += s.substring(0, 1);
                r += s.substring(1);
            }
            // tr(s, l, r);
            res.add(l);
            res.add(r);
        }
        res.add(a[a.length - 1]);
        pr("YES");
        for (int i = 0; i < res.size(); i += 2) pr(res.get(i) + "." + res.get(i + 1));
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        solve(s);
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
        new B174().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}