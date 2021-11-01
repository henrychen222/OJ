// 09/13/21 morning
// https://codeforces.com/contest/1566/problem/C
package codeforce.global.r16;

import java.util.*;
import java.io.*;

public class C {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1566/submission/128725314
    // reference: SecondThread
    void solve(int n, String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) { // 00 11
                cnt[i] = a[i] == '0' ? 1 : 0;
            } else { // 01 10
                cnt[i] = 2;
            }
        }
        boolean freeZero = false;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                freeZero = true;
            } else if (cnt[i] == 1) {
                if (freeZero) {
                    freeZero = false;
                    res += 2;
                } else if (i + 1 < n && cnt[i + 1] == 0) {
                    res += 2;
                    i++;
                } else {
                    res++;
                }
            } else if (cnt[i] == 2) {
                freeZero = false;
                res += 2;
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            String s1 = fs.next();
            String s2 = fs.next();
            solve(n, s1, s2);
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
        new C().run();
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