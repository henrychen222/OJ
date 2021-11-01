/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/13/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A13 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/13/133865682
    // reference: https://codeforces.com/contest/13/standings LayCurse
    void solve(int a) {
        int res = 0, divide = a - 2;
        for (int base = 2; base < a; base++) {
            int sum = sumOfDigit(a, base);
            res += sum;
        }
        int g = gcd(res, divide);
        res /= g;
        divide /= g;
        pr(res + "/" + divide);
    }

    int sumOfDigit(int x, int base) {
        int res = 0;
        while (x > 0) {
            res += x % base;
            x /= base;
        }
        return res;
    }

    // WA
    void solve1(int a) {
        int res = 0, divide = a - 2;
        for (int base = 2; base < a; base++) {
            int sum = 0;
            String s = Integer.toString(a, base);
            // tr(base, s);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    sum += c - '0';
                }
            }
            res += sum;
        }
        int g = gcd(res, divide);
        res /= g;
        divide /= g;
        pr(res + "/" + divide);
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int a = fs.nextInt();
        solve(a);
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
        new A13().run();
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