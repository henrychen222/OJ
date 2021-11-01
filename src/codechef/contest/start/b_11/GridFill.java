/**
 * 09/15/21 morning
 * https://www.codechef.com/START11B/problems/FILLGRID
 */

package codechef.contest.start.b_11;

import java.util.*;
import java.io.*;

class GridFill {

    static PrintWriter pw;

    // Accepted
    /*
     -1  1  1
      1 -1  1
      1  1  -1
     */
    void solve(int n) {
        int[][] g = new int[n][n];
        for (int[] a : g) Arrays.fill(a, 1);
        if (n % 2 == 0) {
            for (int[] a : g) Arrays.fill(a, -1);
            output(g);
            return;
        }
        // tr(g);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    g[i][j] = -1;
                }
            }
        }
        output(g);
    }

    void output(int[][] g) {
        for (int[] a : g) {
            String tmp = "";
            for (int c : a) {
                tmp += c;
                tmp += " ";
            }
            pr(tmp);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new GridFill().run();
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
