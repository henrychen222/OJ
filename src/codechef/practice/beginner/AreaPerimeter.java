/**
 * 01/10/22 morning
 * https://www.codechef.com/problems/AREAPERI
 */
package codechef.practice.beginner;

import java.util.*;
import java.io.*;

class AreaPerimeter {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/56196587
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int l = fs.nextInt(), b = fs.nextInt();
        int Area = l * b, Peri = 2 * (l + b);
        if (Area > Peri) {
            pr("Area");
            pr(Area);
        } else if (Area < Peri) {
            pr("Peri");
            pr(Peri);
        } else {
            pr("Eq");
            pr(Area);
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
        new AreaPerimeter().run();
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

        char nextChar() {
            return next().charAt(0);
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
