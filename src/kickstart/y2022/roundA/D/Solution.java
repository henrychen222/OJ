/**
 * 03/19/22 night
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000008cb33e/00000000009e73ea
 */
package kickstart.y2022.roundA.D;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // TLE  (AC Test Set 1)
    void solve(long a, long b) {
        long res = 0;
        for (long x = a; x <= b; x++) {
            if (isInteresting(x)) res++;
        }
        pr(res);
    }

    boolean isInteresting(long x) {
        String s = x + "";
        long p = 1, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            long t = s.charAt(i) - '0';
            p *= t;
            sum += t;
        }
        return p % sum == 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            long a = fs.nextLong(), b = fs.nextLong();
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
        new Solution().run();
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