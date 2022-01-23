/**
 * 12/1/21 morning
 * https://codeforces.com/contest/1613/problem/0
 */
package codeforce.ecf.r118;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Accepted
    void solve(int[] a, int[] b) {
        int x1 = a[0], p1 = a[1], x2 = b[0], p2 = b[1];
        String s1 = x1 + "", s2 = x2 + "";
        int totL1 = s1.length() + p1;
        int totL2 = s2.length() + p2;
        // tr(s1 + "0".repeat(p1), s2 + "0".repeat(p2), totL1, totL2);
        if (totL1 < totL2) {
            pr("<");
        } else if (totL1 > totL2) {
            pr(">");
        } else {
            // tr("compareString", s1, s2);
            int n = Math.min(s1.length(), s2.length());
            for (int i = 0; i < n; i++) {
                int t1 = s1.charAt(i) - '0', t2 = s2.charAt(i) - '0';
                if (t1 < t2) {
                    pr("<");
                    return;
                } else if (t1 > t2) {
                    pr(">");
                    return;
                }
            }
            if (s1.length() == n) {
                if (s2.length() == n) {
                    pr("=");
                    return;
                } else { // s2 > n
                    String rest = s2.substring(n);
                    for (int i = 0; i < rest.length(); i++) {
                        int t = rest.charAt(i) - '0';
                        if (t > 0) {
                            pr("<");
                            return;
                        }
                    }
                }
            } else {
                String rest = s1.substring(n);
                for (int i = 0; i < rest.length(); i++) { // s1 > n
                    int t = rest.charAt(i) - '0';
                    if (t > 0) {
                        pr(">");
                        return;
                    }
                }
            }
            pr("=");
        }
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2), b = fs.readArray(2);
            solve(a, b);
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
