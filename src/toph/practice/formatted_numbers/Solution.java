/**
 * 10/11/21 morning
 * https://toph.co/p/formatted-numbers
 */
package toph.practice.formatted_numbers;

import java.util.*;
import java.io.*;

class Solution {

    static PrintWriter pw;

    // Accepted --- https://toph.co/s/747350
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        int n = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = n - 1, t = 1; i >= 0; i--, t++) {
            res.append(s.charAt(i));
            if (t % 3 == 0) res.append(',');
        }
        int m = res.length();
        if (res.charAt(m - 1) == ',') res.deleteCharAt(m - 1);
        pr(res.reverse().toString());
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