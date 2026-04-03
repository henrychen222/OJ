/**
 * 08/07/23 morning
 * https://codeforces.com/contest/1857/problem/B
 */
package codeforce.cf.div3.y2023.r891;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1857/submission/217798251
    // reference: chinesedfan
    void solve(String ss) {
        int n = ss.length();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) s[i] = ss.charAt(i) - '0';
        for (int i = 0; i < n; i++) {
            if (s[i] >= 5) {
                int j = i;
                while (j + 1 < n) {
                    j++;
                    s[j] = 0;
                }
                j = i;
                while (j >= 0 && s[j] >= 5) {
                    s[j] = 0;
                    if (j - 1 >= 0 && s[j - 1] == 0) s[j - 1] = 0;
                    j--;
                    if (j >= 0) s[j]++;
                }
                break;
            }
        }
        StringBuilder res = new StringBuilder();
        if (s[0] == 0) res.append('1');
        for (int x : s) res.append(x);
        pr(res);
    }

    /////////////////////////////////////////////////////////////
    // TLE
    void solve1(String s) {
        char first = s.charAt(0);
        int n = s.length();
        boolean can = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= '5') {
                can = true;
                break;
            }
        }
        if (!can) {
            pr(s);
            return;
        }
        while (true) {
            boolean go = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) >= '5') {
                    // tr(s.charAt(i));
                    String l = s.substring(0, i) + "9";
                    s = addStrings(l, "1");
                    // tr("add", s);
                    go = true;
                    break;
                }
            }
            if (!go) break;
        }
        int lack = n - s.length();
        // if (s.charAt(0) == '1') lack++;
        if (first != '1' && s.charAt(0) == '1') lack++;
        // tr(s, n, lack);
        // s = removeTrailingZeros(s);
        pr(s + "0".repeat(lack));
    }

    String removeTrailingZeros(String s) {
        int n = s.length() - 1, end = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                end = i;
                break;
            }
        }
        return s.substring(0, end + 1);
    }

//    String addStrings(String x, String y) {
//        // tr(x, y);
//        BigInteger bx = new BigInteger(x), by = new BigInteger(y);
//        return bx.add(by).toString();
//    }

    public String addStrings(String x, String y) {
        StringBuilder res = new StringBuilder();
        int dot = 0, i = x.length() - 1, j = y.length() - 1;
        while (i >= 0 || j >= 0) {
            int vx = i >= 0 ? x.charAt(i--) - '0' : 0;
            int vy = j >= 0 ? y.charAt(j--) - '0' : 0;
            int sum = vx + vy + dot;
            res.insert(0, sum % 10);
            dot = sum > 9 ? 1 : 0;
        }
        return (dot != 0 ? 1 : "") + res.toString();
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
        new B().run();
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
