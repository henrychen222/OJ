/**
 * 04/02/22 morning
 * https://www.codechef.com/COOK140C/problems/FUNHAND
 */
package codechef.contest.cook.c_140;

import java.util.*;
import java.io.*;

class FunnyHand {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int a, int b) {
        int max = Math.max(a, b), min = Math.min(a, b), diff = max - min;
        if (diff == 1) {
            if (max + 1 <= n) {
                if (min - 1 >= 1) {
                    pr(2);
                } else {
                    pr(1);
                }
            } else {
                if (min - 1 >= 1) {
                    pr(1);
                } else {
                    pr(0);
                }
            }
        } else if (diff == 2) {
            pr(1);
        } else {
            pr(0);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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
        new FunnyHand().run();
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