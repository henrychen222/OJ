/**
 * 03/01/23 noon
 * https://www.codechef.com/START79C/problems/MOUNTAIN
 */
package codechef.contest.start.y2023.c_79;

import java.util.*;
import java.io.*;

class Mountain {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/91221764 (03/01/23 night complete)
    // reference: https://discuss.codechef.com/t/mountain-editorial/105397
    void solve(int n, int m, int q, long[] a) {
        for (long s : a) {
            long curSum = 0, curRow = 1;
            while (true) {
                if (curSum + m * curRow < s) {
                    curSum += m * curRow;
                    curRow++;
                } else {
                    long take = (s - curSum + curRow - 1) / curRow;
                    curSum += curRow * take;
                    pr(1 + " " + curRow);
                    for (int i = 1; i < curRow; i++) {
                        int v = (curSum - i == s ? m - 1 : m);
                        pw.print(v + " ");
                    }
                    pr(take);
                    break;
                }
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), q = fs.nextInt();
        long[] s = fs.readArray(q);
        solve(n, m, q, s);
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
        new Mountain().run();
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

