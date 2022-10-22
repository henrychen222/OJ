/**
 * 06/16/22 morning
 * https://codeforces.com/contest/1694/problem/0
 */
package codeforce.cf.div2.r800;

import java.util.*;
import java.io.*;

public class A {
    static PrintWriter pw;

    // Pretests passed
    void solve(int a, int b) {
        String res = "";
        int min = Math.min(a, b);
        for (int i = 0; i < min; i++) {
            res += '0';
            res += '1';
        }
        if (a < b) {
            res += "1".repeat(b - min);
        } else if (a > b) {
            res += "0".repeat(a - min);
        }
        // tr(res, creep(res));
        pr(res);
    }

    int creep(String s) {
        char[] a = s.toCharArray();
        int res = Integer.MIN_VALUE, one = 0, zero = 0;
        for (char c : a) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
            res = Math.max(res, Math.abs(one - zero));
        }
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(2);
            solve(a[0], a[1]);
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
        new A().run();
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