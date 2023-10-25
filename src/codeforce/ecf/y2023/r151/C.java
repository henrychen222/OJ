/**
 * 06/29/23 morning 08/31/23 evening completed
 * https://codeforces.com/contest/1845/problem/0
 */
package codeforce.ecf.y2023.r151;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1845/submission/221270404
    // reference: Heltion https://codeforces.com/blog/entry/117791
    void solve(String ss, int m, String l, String r) {
        char[] s = ss.toCharArray();
        int n = s.length, cur = -1;
        int[][] next = new int[n + 1][10];
        Arrays.fill(next[n], n);
        // tr(next);
        for (int i = n - 1; i >= 0; i--) { // next[i][j]: next occurrence of digit j from position i
            next[i] = Arrays.copyOf(next[i + 1], next[i + 1].length);
            next[i][s[i] - '0'] = i;
        }
        // tr(next);
        for (int i = 0; i < m && cur < n; i++) {
            int nxt = 0;
            for (int j = l.charAt(i) - '0'; j <= r.charAt(i) - '0'; j++) {
                nxt = Math.max(nxt, next[cur + 1][j]);
            }
            // tr("nxt", nxt);
            cur = nxt;
        }
        pr(cur == n ? "YES" : "NO");
    }

    ////////////////////////////////////////////////////////////
    // TLE
    void solve1(String ss, int m, String l, String r) {
        char[] s = ss.toCharArray();
        // tr(ss, m, l, r);
        for (String cur = l; cur.compareTo(r) <= 0; cur = next(cur, m)) {
            if (ok(cur, l, r) && !isSubsequence(s, cur)) {
                // tr(cur);
                pr("YES");
                return;
            }
        }
        pr("NO");
    }

    boolean ok(String cur, String l, String r) {
        int n = l.length();
        // tr(cur, l, r, n, cur.length(), r.length());
        for (int i = 0; i < n; i++) {
            char c = cur.charAt(i), lc = l.charAt(i), rc = r.charAt(i);
            if (c < lc || c > rc) return false;
        }
        return true;
    }

    String next(String s, int m) {
        String res = (Long.parseLong(s) + 1) + "";
        if (res.length() < m) res = "0".repeat(m - res.length()) + res;
        return res;
    }

    boolean isSubsequence(char[] s, String t) { // t is subsequence of s
        int tn = t.length();
        int sn = s.length, i = 0, j = 0;
        while (i < sn && j < tn) {
            if (s[i] == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == tn;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            int m = fs.nextInt();
            String l = fs.next(), r = fs.next();
            solve(s, m, l, r);
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
