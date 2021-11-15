/**
 * 11/13/21 afternoon
 * https://codeforces.com/problemset/problem/447/B
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class B447 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/447/135328557
    // reference: nevergiveup kmjp
    void solve(String s, int k, int[][] a, int[] b) {
        Arrays.sort(a, (x, y) -> y[0] - x[0]);
        int max = a[0][0], n = s.length();
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) (i + 1) * b[s.charAt(i) - 'a'];
        }
        for (int i = n + 1; i <= n + k; i++) res += (long) i * max;
        pr(res);
    }

    // WA 12 test case  don't know
    void solve1(String s, int k, int[][] a, int[] b) { // append max each wrong, s + app (small v...large v) also wrong
        Arrays.sort(a, (x, y) -> y[0] - x[0]);
//        tr("a", a);
//        tr("b", b);
        int cnt = 0;
        String app = "";
        for (int[] e : a) {
            int x = e[0];
            String c = ((char) (e[1] + 'a')) + "";
            // tr("cnt", cnt, "x", x, "c", c, s);
            if (cnt + x >= k) {
                int need = k - cnt;
                app = c.repeat(need) + app;
                break;
            }
            app = c.repeat(x) + app;
            cnt += x;
        }
        s += app;
        // tr(s);
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (long) (i + 1) * b[s.charAt(i) - 'a'];
        }
        pr(res);
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        String s = fs.next();
        int k = fs.nextInt();
        int[][] a = new int[26][];
        int[] b = new int[26];
        for (int i = 0; i < 26; i++) {
            b[i] = fs.nextInt();
            a[i] = new int[]{b[i], i};
        }
        solve(s, k, a, b);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B447().run();
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
