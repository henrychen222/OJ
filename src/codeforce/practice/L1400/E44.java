/**
 * 11/27/23 noon  finished 11/27/23 evening
 * https://codeforces.com/problemset/problem/44/E
 */
package codeforce.practice.L1400;

import java.util.*;
import java.io.*;

public class E44 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/44/234650897
    // WA --- https://codeforces.com/problemset/submission/44/234622170
    void solve(int k, int a, int b, String s) {
//        int n = s.length();
//        int max = (n + a) / a, min = (n + b) / b;
//        if (k < min || k > max) {
//            pr("No solution");
//            return;
//        }
        for (int x = a; x <= b; x++) {
            List<String> res = cutWithKLength(s, x);
            // tr(res, isValid(res, a, b, k));
            if (isValid(res, a, b, k)) {
                for (String e : res) pr(e);
                return;
            } else {
                if (res.size() >= 2) {
                    String last = res.get(res.size() - 1), secondLast = res.get(res.size() - 2);
                    if (last.length() + secondLast.length() <= b) {
                        res.remove(res.size() - 1);
                        res.remove(res.size() - 1);
                        res.add(secondLast + last);
                        if (isValid(res, a, b, k)) {
                            for (String e : res) pr(e);
                            return;
                        }
                    }
                }
            }
        }
        pr("No solution");
    }

    List<String> cutWithKLength(String s, int k) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (cur.length() == k) {
                res.add(cur.toString());
                cur = new StringBuilder();
            }
            cur.append(s.charAt(i));
        }
        res.add(cur.toString());
        return res;
    }

    boolean isValid(List<String> l, int L, int R, int k) {
        if (l.size() != k) return false;
        for (String e : l) {
            if (e.length() < L || e.length() > R) return false;
        }
        return true;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int[] a = fs.readArray(3);
        String s = fs.next();
        solve(a[0], a[1], a[2], s);
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
        new E44().run();
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
