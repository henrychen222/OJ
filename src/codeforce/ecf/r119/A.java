/**
 * 12/18/21 morning
 * https://codeforces.com/contest/1620/problem/A
 */
package codeforce.ecf.r119;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1620/submission/139824980
    void solve(String s) {
        int cnt = 0;
        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == 'N') cnt++;
        }
        pr(cnt == 1 ? "NO" : "YES");
    }

    // WA
    void solve3(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        if (n == 2) {
            if (s.equals("NE") || s.equals("EN")) {
                pr("NO");
                return;
            }
        } else {
            String judge = "" + a[n - 2] + a[n - 1];
            // tr("judge", judge);
            boolean allE = true;
            for (int i = 0; i < n - 2; i++) {
                if (a[i] == 'N') {
                    allE = false;
                    break;
                }
            }
            if (allE && (judge.equals("EN") || judge.equals("NE"))) {
                pr("NO");
                return;
            }
        }
        pr("YES");
    }

    // WA
    void solve2(String s) {
        int n = s.length();
        if (n > 3) {
            pr("YES");
        } else if (n == 2) {
            if (s.equals("NE") || s.equals("EN")) {
                pr("NO");
            } else {
                pr("YES");
            }
        } else if (n == 3) {
            if (s.equals("ENE") || s.equals("EEN")) {
                pr("NO");
            } else {
                pr("YES");
            }
        }
    }

    // WA
    void solve1(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int[] a = new int[n];
        a[0] = 1;
        for (int i = 0; i + 1 < n; i++) {
            if (s[i] == 'E') {
                a[i + 1] = a[i];
            } else {
                a[i + 1] = a[i] + 1;
            }
        }
        // tr(s, a);
        if (s[n - 1] == 'E' && s[n - 2] == 'N' && a[n - 2] != a[0]) a[n - 1] = a[0];
        // tr(a);
        if (s[n - 1] == 'E') {
            pr(a[n - 1] == a[0] ? "YES" : "NO");
        } else {
            pr(a[n - 1] != a[0] ? "YES" : "NO");
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            solve(s);
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
