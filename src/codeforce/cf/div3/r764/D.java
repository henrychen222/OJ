/**
 * 01/10/22 morning
 * https://codeforces.com/contest/1624/problem/D
 */
package codeforce.cf.div3.r764;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1624/submission/142293380
    // reference: chinesedfan
    void solve(int n, int k, String s) {
        char[] a = s.toCharArray();
        int[] f = new int[26];
        for (char c : a) f[c - 'a']++;
        int even = 0;
        for (int x : f) {
            if (x % 2 != 0) {
                even += x - 1;
            } else {
                even += x;
            }
        }
        // tr(even);
        int low = 1, high = n / k;
        pr(binarySearch(low, high, even, k));
    }

    int binarySearch(int low, int high, int even, int k) {
        // tr(low, high);
        while (low <= high) {
            int m = low + high >> 1;
            // tr("mid", m, possible(even, m, k));
            if (possible(m, even, k)) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return high;
    }

    boolean possible(int m, int even, int k) {
        // tr("poss", m, even, k);
        if (m % 2 != 0) {
            return even >= (m - 1) * k;
        } else {
            return even >= m * k;
        }
    }

    // WA
    void solve1(int n, int k, String s) {
        // tr(n, k, s);
        char[] a = s.toCharArray();
        int[] f = new int[26];
        for (char c : a) f[c - 'a']++;
        int odd = 0;
        for (int x : f) {
            if (x % 2 != 0) {
                odd++;
            }
        }
        int cnt = n / k;
        // tr(f, cnt, odd);
        if (odd <= 1) {
            pr(cnt);
        } else {
            pr(Math.max(cnt - odd + 1, 1));
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            String s = fs.next();
            solve(n, k, s);
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
        new D().run();
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