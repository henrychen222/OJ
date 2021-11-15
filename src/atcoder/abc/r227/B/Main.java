/**
 * 11/13/21 morning
 * https://atcoder.jp/contests/abc227/tasks/abc227_b
 */
package atcoder.abc.r227.B;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    /**
     * 3a + 3b + 4ab = s
     * 3a = s - 4ab - 3b
     * 3b = s - 4ab - 3a
     */
    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), res = 0;
        int[] A = fs.readArray(n);
        for (int s : A) {
            boolean find = false;
            outer:
            for (int a = 1; a * 3 < s; a++) {
                for (int b = 1; b * 3 < s; b++) {
                    if (3 * a + 3 * b + 4 * a * b == s) {
                        // tr(s, a, b);
                        find = true;
                        break outer;
                    }
                }
            }
            if (!find) res++;
        }
        pr(res);
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