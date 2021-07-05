/**
 * 07/05/21 afternoon
 * https://www.codechef.com/problems/CIELRCPT
 */

package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class CielReceipt {

    static PrintWriter pw;

    int[] d;

    // Accepted --- 0.05sec https://www.codechef.com/viewsolution/48553902
    void solve(int x) {
        int i = 11;
        int res = 0;
        while (x > 1) {
            // tr(x, d[i]);
            while (x < d[i]) {
                i--;
            }
            res += x / d[i];
            x %= d[i];
            // tr(x, d[i]);
        }
        // pr(x);
        pr(res + x);
    }

    void prepare() {
        d = new int[12];
        for (int i = 0; i < 12; i++) {
            d[i] = (int) Math.pow(2, i);
        }
        // tr(d);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        prepare();
        int t = fs.nextInt();
        while (t-- > 0) {
            int x = fs.nextInt();
            solve(x);
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
        new CielReceipt().run();
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