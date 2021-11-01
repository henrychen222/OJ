/**
 * 10/11/21 morning
 * http://acm.hdu.edu.cn/showproblem.php?pid=1003
 */
package poj.p1001;

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    /**
     * Accepted
     * http://poj.org/showsource?solution_id=23013957
     * http://poj.org/showsource?solution_id=23013984
     *
     * reference: https://vjudge.net/problem/POJ-1001
     */
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        try {
            while (true) {
                String r = fs.next();
                int n = fs.nextInt();
                BigDecimal R = new BigDecimal(r);
                BigDecimal res = R.pow(n);
//                String s = res.toString();
                String s = res.stripTrailingZeros().toPlainString(); // fixed
                if (s.charAt(0) == '0') s = s.substring(1);
                pr(s);
            }
        } catch (NullPointerException e) {
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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