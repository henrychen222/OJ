/**
 * 03/30/22 morning
 * https://www.codechef.com/START32C/problems/BSCOST
 */
package codechef.contest.start.c_32;

import java.util.*;
import java.io.*;

class BinaryStringCost {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int x, int y, String s) {
        char[] a = s.toCharArray();
        int zero = 0, one = 0;
        for (char c : a) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        if (zero > 0 && one > 0) {
            pr(Math.min(x, y));
        } else {
            pr(0);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), x = fs.nextInt(), y = fs.nextInt();
            String s = fs.next();
            solve(n, x, y, s);
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
        new BinaryStringCost().run();
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
