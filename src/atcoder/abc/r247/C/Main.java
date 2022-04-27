/**
 * 04/10/22 morning
 * https://atcoder.jp/contests/abc247/tasks/abc247_c
 */
package atcoder.abc.r247.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;
    String[] dp;

    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        prepare();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        String s = dp[n - 1];
//        int len = s.length();
//        String res = "";
//        for (int i = 0; i < len; i++) {
//            res += s.charAt(i);
//            if (i != len - 1) res += ' ';
//        }
        pr(s);
    }

    void prepare() {
        dp = new String[17];
        dp[0] = "1";
        for (int i = 1; i < 17; i++) {
            dp[i] = dp[i - 1] + " " + (i + 1) + " " + dp[i - 1];
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
        new Main().run();
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