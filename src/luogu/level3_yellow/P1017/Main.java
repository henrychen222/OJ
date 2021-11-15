/**
 * 11/11/21 afternoon
 * https://www.luogu.com.cn/problem/P1017
 *
 * reference:
 * https://en.wikipedia.org/wiki/Negative_base
 *
 * similar problem:
 * https://leetcode.com/problems/convert-to-base-2/
 */
package luogu.level3_yellow.P1017;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62308053
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int x = fs.nextInt(), base = fs.nextInt();
        // tr(x, base, Character.MIN_RADIX);
        String res = toAnyBase(x, base);
        pr(x + "=" + res + "(base" + base + ")");
    }

    String toAnyBase(int x, int base) { // max base 20
        String res = "";
        String[] d = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        while (x != 0) {
            int rem = x % base;
            x /= base;
            if (rem < 0) {
                rem += Math.abs(base);
                x++;
            }
            res = d[rem] + res;
        }
        return res;
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
        new Main().run();
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