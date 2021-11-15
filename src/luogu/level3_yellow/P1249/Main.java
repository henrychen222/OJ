/**
 * 11/11/21 evening
 * https://www.luogu.com.cn/problem/P1249
 */
package luogu.level3_yellow.P1249;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62309103
    // reference: https://blog.csdn.net/i_have_a_world/article/details/109085608
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        TreeSet<Integer> ts = new TreeSet<>();
        long sum = 0;
        int p = -1;
        for (int x = 2; ; x++) {
            ts.add(x);
            p = x;
            sum += x;
            if (sum + x + 1 > n) break;
        }
        n -= sum;
        // tr(ts);
        if (n == p) {
            ts.add(p + 2);
            ts.remove(2);
        } else if (n > 0) {
            ts.add(p + 1);
            ts.remove(p + 1 - n);
        }
        // tr(ts);
        BigInteger res = new BigInteger("1");
        String s = "";
        int i = 1, len = ts.size();
        for (int e : ts) {
            s += e;
            if (i != len) s += " ";
            res = res.multiply(new BigInteger(e + ""));
            i++;
        }
        pr(s);
        pr(res.toString());
    }

    // WA
    private void run1() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        TreeSet<Integer> ts = new TreeSet<>();
        while (n % 2 == 0) {
            n /= 2;
            ts.add(n);
        }
        int x = n / 2, y = x + 1;
        ts.add(x);
        ts.add(y);
        String s = "";
        BigInteger p = new BigInteger("1");
        int i = 1, len = ts.size();
        for (int e : ts) {
            s += e;
            if (i != len) s += " ";
            p = p.multiply(new BigInteger(e + ""));
            i++;
        }
        // tr(ts, s.length());
        pr(s);
        pr(p.toString());
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