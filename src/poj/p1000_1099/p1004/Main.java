/**
 * 05/23/22 afternoon
 * http://poj.org/problem?id=1004
 */
package poj.p1000_1099.p1004;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- 94ms http://poj.org/showsource?solution_id=23517098
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            double x = fs.nextDouble();
            sum += x;
        }
        // tr(sum, sum / 12);
        pr("$" + round(sum / 12, 2));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value *= factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}