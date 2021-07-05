/**
 * 07/05/21 morning
 * https://www.codechef.com/problems/TLG
 */

package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class TheLeadGame {

    static PrintWriter pw;

    // Accepted --- 0.15sec  https://www.codechef.com/viewsolution/48540773
    void solve(int n, int[] a, int[] b) {
        Map<Integer, Integer> m = new HashMap<>();
        int sa = 0, sb = 0, diff = 0;
        for (int i = 0; i < n; i++) {
            sa += a[i];
            sb += b[i];
            int curDiff = Math.abs(sa - sb);
            if (sa > sb) {
                m.put(curDiff, 1);
            } else {
                m.put(curDiff, 2);
            }
            diff = Math.max(diff, curDiff);
            // tr(sa, sb, diff);
        }
        pr(m.get(diff) + " " + diff);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            b[i] = fs.nextInt();
        }
        solve(n, a, b);
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
        new TheLeadGame().run();
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