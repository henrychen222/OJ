/**
 * 09/12/21 morning
 * https://codeforces.com/contest/1566/problem/B
 */
package codeforce.global.r16;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // 09/13/21 morning
    // Accepted https://codeforces.com/contest/1566/submission/128713907
    // reference: SecondThread
    void solve(String s) {
        int n = s.length();
        char[] a = s.toCharArray();
        boolean hasZero = false;
        for (char c : a) {
            if (c == '0') hasZero = true;
        }
        int zeroGroup = a[0] == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (a[i] == '0' && a[i - 1] == '1') zeroGroup++;
        }
        if (!hasZero) {
            pr(0);
        } else if (zeroGroup == 1) {
            pr(1);
        } else {
            pr(2);
        }
    }


    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            String s = fs.next();
            solve(s);
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