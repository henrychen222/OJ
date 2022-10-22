/**
 * 08/26/22 evening
 * https://codeforces.com/problemset/problem/133/B
 *
 * similar problem:
 * https://www.codechef.com/START44C/problems/JOGGING
 */
package codeforce.practice.L1200;

import java.util.*;
import java.io.*;

/*
  ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
 */
// Accepted --- https://codeforces.com/problemset/submission/133/169750722
public class B133 {
    static PrintWriter pw;
    final int mod = (int) 1e6 + 3;
    Map<Character, String> m = new HashMap<>() {{
        put('>', "1000");
        put('<', "1001");
        put('+', "1010");
        put('-', "1011");
        put('.', "1100");
        put(',', "1101");
        put('[', "1110");
        put(']', "1111");
    }};

    void solve(char[] s) {
        String t = "";
        for (char c : s) t += m.get(c);
        long res = 0;
        // tr(t);
        long[] p = buildPowerArray(t.length());
        p = reverseA(p);
        // tr(p);
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '1') {
                // long v = 1L << (t.length() - i - 1);
                long v = p[i];
                // tr(i, v, res);
                res += v;
                res %= mod;
            }
        }
        pr(res);
    }

    long[] buildPowerArray(int n) {
        long[] power = new long[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) power[i] = power[i - 1] * 2 % mod;
        return power;
    }

    long[] reverseA(long[] a) {
        int n = a.length;
        long[] b = new long[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    private void run() throws IOException {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        char[] s = fs.readLine().toCharArray();
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B133().run();
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

        String readLine() throws IOException {
            return br.readLine();
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}