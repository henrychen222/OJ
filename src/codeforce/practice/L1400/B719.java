/**
 * 04/19/23 night
 * https://codeforces.com/problemset/problem/719/B
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class B719 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/719/202785809
    // reference: https://codeforces.com/contest/719/standings/friends/true nevergiveup
    void minStepToMakeAlternate(int n, char[] s) {
        pr(Math.min(go(s, "rb"), go(s, "br")));
    }

    int go(char[] s, String t) {
        int n = s.length, r = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (s[i] == t.charAt(0)) r++;
            } else {
                if (s[i] == t.charAt(1)) b++;
            }
        }
        return Math.min(r, b) + Math.abs(r - b);
    }

    //////////////////////////////////////////////////////
    // WA
    void minStepToMakeAlternate1(int n, char[] s) {
        char[] a = new char[n], b = new char[n];
        a[0] = 'b';
        b[0] = 'r';
        for (int i = 1; i < n; i++) {
            a[i] = toggle(a[i - 1]);
            b[i] = toggle(b[i - 1]);
        }
        int res1 = work(s, a), res2 = work(s, b);
        pr(Math.min(res1, res2));
    }

    int work(char[] s, char[] t) {
//        tr(new String(s));
//        tr(new String(t));
        int res = 0, n = s.length;
        for (int i = 0; i < n; ) {
            if (s[i] != t[i]) {
                tr(i, s[i], res);
                if (i + 1 < n && (s[i] + "" + s[i + 1]).equals(t[i + 1] + "" + t[i])) {
                    i += 2;
                } else {
                    i++;
                }
                res++;
            } else {
                i++;
            }
        }
        // tr("res", res);
        return res;
    }

    char toggle(char c) {
        return c == 'b' ? 'r' : 'b';
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        char[] s = fs.next().toCharArray();
        minStepToMakeAlternate(n, s);
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
        new B719().run();
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