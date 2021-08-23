package codeforce.cf.round732_div2;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted
    // https://codeforces.com/contest/1546/submission/122142090 218ms
    // https://codeforces.com/contest/1546/submission/122142019 220ms
    // reference: https://codeforces.com/contest/1546/submission/122085108
    void solve(int n, int m, String[] a, String[] b) {
        int[] aa = new int[26];
        int[] bb = new int[26];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) v[i] = 0;
        for (int p = 0; p < m; p++) {
            for (int i = 0; i < 26; i++) aa[i] = bb[i] = 0;
            for (int i = 0; i < n; i++) {
                if (i < n - 1) bb[b[i].charAt(p) - 'a']++;
                aa[a[i].charAt(p) - 'a']++;
            }
            char k = 'a';
            for (int i = 0; i < 26; i++) {
                if (aa[i] != bb[i]) k = (char) ('a' + i);
            }
            for (int i = 0; i < n; i++) if (a[i].charAt(p) == k) v[i]++;
        }
//        tr(aa, bb);
//        tr(a, v, m);
        for (int i = 0; i < n; i++) {
            if (v[i] == m) {
                pr(a[i]);
                return;
            }
        }
    }

    // WA
    void solve1(int n, int m, String[] a, String[] b) {
        for (String s1 : a) {
            boolean flag = false;
            for (String s2 : b) {
                if (match(s1, s2)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                pr(s1);
                return;
            }
        }
    }

    boolean match(String s1, String s2) {
        int n = s1.length();
        int same = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) same++;
        }
        return same >= Math.ceil(n / 2);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            String[] a = new String[n];
            String[] b = new String[n - 1];
            for (int i = 0; i < n; i++) a[i] = fs.next();
            for (int i = 0; i < n - 1; i++) b[i] = fs.next();
            solve(n, m, a, b);
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
        new B().run();
        pw.close();
        // pw.flush();  // doesn't matter for interactive problem
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