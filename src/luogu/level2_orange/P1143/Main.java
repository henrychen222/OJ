/**
 * 11/12/21 noon
 * https://www.luogu.com.cn/problem/P1143
 */
package luogu.level2_orange.P1143;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62391528
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int b1 = fs.nextInt();
        String s1 = fs.next();
        int b2 = fs.nextInt();
        int x = AnyBaseToDecimal(s1, b1);
        pr(DecimalToAnyBase(x, b2));
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

    // https://www.geeksforgeeks.org/convert-base-decimal-vice-versa/
    int AnyBaseToDecimal(String s, int fromBase) {
        int n = s.length(), power = 1, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += d.indexOf(s.charAt(i)) * power;
            power *= fromBase;
        }
        return res;
    }

    String d = "0123456789ABCDEFGHIJK";

    String DecimalToAnyBase(int x, int ToBase) { // max base depends on d, base can be negative
        String res = "";
        while (x != 0) {
            int rem = x % ToBase;
            x /= ToBase;
            if (rem < 0) {
                rem += Math.abs(ToBase);
                x++;
            }
            res = d.charAt(rem) + res;
        }
        return res;
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