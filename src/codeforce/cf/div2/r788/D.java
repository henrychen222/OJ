/**
 * 05/06/22 afternoon
 * https://codeforces.com/contest/1670/problem/D
 */
package codeforce.cf.div2.r788;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;
    int n;

    // Accepted --- https://codeforces.com/contest/1670/submission/156142382
    // reference: um_nik
    void solve() {
        pr(binarySearch(0, n));
    }

    int binarySearch(int low, int high) {
        while (low <= high) {
            int m = low + high >> 1;
            if (possible(m)) {
                low = m + 1;
            } else {
                high = m - 1;
            }
        }
        return low;
    }

    boolean possible(int x) {
        int y = x / 3;
        x -= y;
        int z = x / 2;
        x -= z;
        long cnt = 2 * ((long) x * y + (long) x * z + (long) y * z);
        return cnt < n;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            n = fs.nextInt();
            solve();
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
        new D().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}