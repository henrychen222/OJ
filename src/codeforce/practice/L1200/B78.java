/**
 * 07/06/22 night
 * https://codeforces.com/problemset/problem/78/B
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

public class B78 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/78/163060574
    void solve(int n) {
        char[] a = {'R', 'O', 'Y', 'G', 'B', 'I', 'V'};
        String s = "", last = "";
        for (char c : a) s += c;
        s = s.repeat(n / 7);
        int need = n % 7;
        if (need == 1) {
            last = "G";
        } else if (need == 2) {
            last = "YG";
        } else if (need == 3) {
            last = "OYG";
        } else if (need == 4) {
            last = "GBIV";
        } else if (need == 5) {
            last = "YGBIV";
        } else if (need == 6) {
            last = "OYGBIV";
        }
        String res = s + last;
        pr(res);
        // tr(n, test(res), res.length(), res, need);
    }

    boolean test(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // tr("cur", a[i], i);
            for (int j = i, cnt = 0; cnt < 4; j = circularArrayNext(j, n), cnt++) {
                // tr("right", j, a[j]);
                if (i != j && a[i] == a[j]) return false;
            }
            for (int j = i, cnt = 0; cnt < 4; j = circularArrayPre(j, n), cnt++) {
                // tr("left", a[j]);
                if (i != j && a[i] == a[j]) return false;
            }
        }
        return true;
    }

    int circularArrayNext(int i, int n) {
        return i + 1 < n ? i + 1 : 0;
    }

    int circularArrayPre(int i, int n) {
        return i - 1 >= 0 ? i - 1 : n - 1;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        solve(n);
        // for (int i = 7; i <= 100; i++) solve(i);
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
        new B78().run();
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