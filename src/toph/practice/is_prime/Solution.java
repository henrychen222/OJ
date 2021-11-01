/**
 * 10/11/21 morning
 * https://toph.co/p/is-prime
 */
package toph.practice.is_prime;

import java.util.*;
import java.io.*;

class Solution {

    static PrintWriter pw;

    // Accepted --- https://toph.co/s/747358
    TreeSet<Integer> sieveEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        TreeSet<Integer> se = new TreeSet<>();
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (!prime[p]) continue;
            for (int i = p * p; i <= n; i += p) prime[i] = false;
        }
        for (int i = 2; i <= n; i++) {
            if (prime[i]) se.add(i);
        }
        return se;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        TreeSet<Integer> ts = sieveEratosthenes(1000);
        int x = fs.nextInt();
        pr(ts.contains(x) ? "Yes" : "No");
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
