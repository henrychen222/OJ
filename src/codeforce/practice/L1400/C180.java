/**
 * 12/23/22 morning
 * https://codeforces.com/problemset/problem/180/C
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class C180 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/180/186487270
    // reference: https://codeforces.com/contest/180/standings proitm
    void solve(char[] s) {
        int n = s.length;
        int[] pre = new int[n + 1], suf = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(s[i])) {
                pre[i + 1] = pre[i] + 1;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (Character.isUpperCase(s[i])) {
                suf[i] = suf[i + 1] + 1;
            } else {
                suf[i] = suf[i + 1];
            }
        }
        int res = n;
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, pre[i] + suf[i]);
        }
        pr(res);
    }

    // WA
    void solve1(char[] s) {
        List<char[]> d = cutMaxConsecutive(s);
        debugArrayInList(d);
        boolean findLower = false, findUpper = false;
        long res1 = 0, res2 = 0;
        for (char[] e : d) {
            if (findLower) {
                if (Character.isUpperCase(e[0])) res1 += e.length;
            }
            if (Character.isLowerCase(e[0])) findLower = true;
        }
        for (int i = d.size() - 1; i >= 0; i--) {
            if (findUpper) {
                if (Character.isLowerCase(d.get(i)[0])) {
                    tr(d.get(i));
                    res2 += d.get(i).length;
                }
            }
            if (Character.isUpperCase(d.get(i)[0])) findUpper = true;
        }
        tr(res1, res2);
        pr(Math.min(res1, res2));
    }

    boolean different(char x, char y) {
        return (Character.isLowerCase(x) && Character.isUpperCase(y)) || (Character.isLowerCase(y) && Character.isUpperCase(x));
    }

    List<char[]> cutMaxConsecutive(char[] a) {
        List<char[]> d = new ArrayList<>();
        int start = 0, n = a.length;
        for (int i = 0; i + 1 < n; i++) {
            if (different(a[i + 1], a[i])) {
                d.add(Arrays.copyOfRange(a, start, i + 1));
                start = i + 1;
            }
        }
        d.add(Arrays.copyOfRange(a, start, n));
        return d;
    }

    void debugArrayInList(List<char[]> l) {
        char[][] res = new char[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.next().toCharArray();
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
        new C180().run();
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