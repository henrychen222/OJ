/**
 * 11/08/21 morning
 * https://www.luogu.com.cn/problem/P1009
 */
package luogu.level2_orange.P1009;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62067081
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        BigInteger res = new BigInteger("0");
        for (int x = 1; x <= n; x++) {
            BigInteger t = factorial(x, x - 1);
            res = res.add(t);
        }
        pr(res.toString());
    }

    BigInteger factorial(int m, int n) { // (5, 2)  5 * 4    (5, 5)  5 * 4 * 3 * 2 * 1
        BigInteger res = new BigInteger("1");
        int cnt = 0;
        for (int i = m; i > 0; i--) {
            if (cnt == n) break;
            res = res.multiply(new BigInteger(i + ""));
            cnt++;
        }
        return res;
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