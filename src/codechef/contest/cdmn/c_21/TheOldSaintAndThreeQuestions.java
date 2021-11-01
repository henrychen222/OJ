/**
 * 09/02/21 morning
 * https://www.codechef.com/CDMN21C/problems/THREEQ
 */
package codechef.contest.cdmn.c_21;

import java.util.*;
import java.io.*;

class TheOldSaintAndThreeQuestions {

    static PrintWriter pw;

    // Accepted
    void solve(int[] a, int[] b) {
        // tr(a, b);
        int a0 = 0, a1 = 0, b0 = 0, b1 = 0;
        for (int i = 0; i < 3; i++) {
            if (a[i] == 0) {
                a0++;
            } else {
                a1++;
            }
            if (b[i] == 0) {
                b0++;
            } else {
                b1++;
            }
        }
        // tr(a0, a1, b0, b1);
        if (a0 == b0 && a1 == b1) {
            pr("Pass");
            return;
        }
        pr("Fail");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            int[] b = fs.readArray(3);
            solve(a, b);
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
        new TheOldSaintAndThreeQuestions().run();
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