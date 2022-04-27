/**
 * 03/24/22 morning
 * https://codeforces.com/contest/1656/problem/B
 */
package codeforce.codeton.r1;

import java.util.*;
import java.io.*;

public class B {
    static PrintWriter pw;

    /*
     2 + 2 + (-2) = 7 - 5

     4 + 2 + 2 = 8
     7 - 4 - (2 - 4) - (2 - 4 - 2)  = 5 - (-4)

     7 - 4 - 2 + 4 - 2 + 4 + 2
     7 - 4 - 2 - 2 + (4 * 2 + 2 * 1 + 2 * 0) (4, 2, 2)

     7 - 4 - 2 - 2 + (2 * 2 + 2 * 1 + 4 * 0) = 5 (2, 2, 4)
                         (n-2)            0
     */
    void solve(int n, int k, int[] a) {
//        long sum = 0;
//        for (int x : a) sum += x;
//        for (int x : a) {
//            long restSum = sum - x, expect = (long) k - x + restSum; // (n - 2)
//            tr(expect);
//        }

        /**
         * Accepted ---  https://codeforces.com/contest/1656/submission/150823886
         * reference: cuiaoxiang
         * https://codeforces.com/blog/entry/101211
         *
         * the final element will be the difference between the last element and the previous element which was erased
         * just need to check if 𝑘 is the difference of two elements in the set
         */
        Set<Integer> se = new HashSet<>();
        for (int x : a) se.add(x);
        for (int x : a) {
            if (se.contains(x + k)) {
                pr("YES");
                return;
            }
        }
        pr("NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, k, a);
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
        new B().run();
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