/**
 * 12/16/21 morning
 * https://codeforces.com/contest/1617/problem/0
 */
package codeforce.cf.div2.r761;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // TLE
    void solve1(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        while (true) {
            if (!isSubsequence(a, b)) {
                pr(new String(a));
                return;
            }
            next_permutation(a);
        }
    }

    // Pretests passed
    void solve(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(b);
        String smallest = new String(b);
        next_permutation(b);
        String next_small = new String(b);
        String order = t.equals(smallest) ? next_small : smallest;
        // tr("s", s, "t", t, "order", order);
        int[] f = new int[26];
        for (char c : a) f[c - 'a']++;
        if (f[0] == 0 || f[1] == 0 || f[2] == 0) { // a b c not full
            Arrays.sort(a);
            pr(new String(a));
            return;
        }
        String res = "";
        if (order.equals(smallest)) { // 'abc'
            for (int i = 0; i < 26; i++) {
                if (f[i] == 0) continue;
                char c = (char) ('a' + i);
                String tmp = (c + "").repeat(f[c - 'a']);
                res += tmp;
            }
        } else { // 'acb'
            res += "a".repeat(f[0]);
            res += "c".repeat(f[2]);
            res += "b".repeat(f[1]);
            for (int i = 3; i < 26; i++) {
                if (f[i] == 0) continue;
                char c = (char) ('a' + i);
                String tmp = (c + "").repeat(f[c - 'a']);
                res += tmp;
            }
        }
        pr(res);
    }

    boolean isSubsequence(char[] s, char[] t) {
        int sn = s.length, tn = t.length, i = 0, j = 0;
        while (i < sn && j < tn) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == tn;
    }

    boolean next_permutation(char[] a) { // array inside can be char ('0' ~ '9', 'a' ~ 'z') and int[]
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        while (T-- > 0) {
            String s = fs.next(), t = fs.next();
            solve(s, t);
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