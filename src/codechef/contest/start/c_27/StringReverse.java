/**
 * 02/23/22 morning
 * https://www.codechef.com/START27C/problems/STR_REVERSE
 *
 * reference:
 * https://www.codechef.com/viewsolution/59019124
 * https://www.codechef.com/viewsolution/58984977
 */
package codechef.contest.start.c_27;

import java.util.*;
import java.io.*;

class StringReverse {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/59027883
    void solve2(String S) {
        int n = S.length(), res = n, j = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == S.charAt(n - 1 - j)) {
                j++;
                res--;
            }
        }
        pr(res);
    }

    ////////////////////////////////////////////////////
    void solve(String S) {
        String T = fast_reverse(S);
        int n = S.length(), res = n, j = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
                res--;
            }
            // tr("i", i, s[i], "j", j, t[j], "res", res);
        }
        pr(res);
    }

    // Accepted --- https://www.codechef.com/viewsolution/59028993
    // https://stackoverflow.com/questions/2439141/what-is-the-most-efficient-algorithm-for-reversing-a-string-in-java
    String fast_reverse2(String s) {
        char[] a = s.toCharArray();
        int n = a.length, h = n / 2;
        for (int i = 0; i < h; i++) {
            char tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = tmp;
        }
        return new String(a);
    }

    // Accepted --- https://www.codechef.com/viewsolution/59028104
    String fast_reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /*
       TLE (reverse is not efficient)
       https://www.codechef.com/viewsolution/59027120
       https://www.codechef.com/viewsolution/59027264
     */
    String reverse1(String s) {
        int n = s.length();
        String res = "";
        for (int i = n - 1; i >= 0; i--) res += s.charAt(i);
        return res;
    }

    // Runtime Error
    // https://www.codechef.com/viewsolution/59028599
    String reverse_recursion(String s) {
        if (s.length() <= 1) return s;
        return reverse_recursion(s.substring(1)) + s.charAt(0);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            String S = fs.next();
            solve(S);
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
        new StringReverse().run();
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
