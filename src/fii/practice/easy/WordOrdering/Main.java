/**
 * 11/21/21 afternoon
 * https://csacademy.com/contest/archive/task/word_ordering/
 */
package fii.practice.easy.WordOrdering;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://csacademy.com/submission/3555705/
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        String s = fs.next();
        int n = fs.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) a[i] = fs.next();
        Arrays.sort(a, (x, y) -> {
            int m = Math.min(x.length(), y.length());
            for (int i = 0; i < m; i++) {
                char cx = x.charAt(i), cy = y.charAt(i);
                if (cx != cy) {
                    if (Character.isLowerCase(cx)) {
                        if (Character.isLowerCase(cy)) {
                            return s.indexOf(cx) - s.indexOf(cy);
                        } else {
                            return -1;
                        }
                    } else {
                        if (Character.isLowerCase(cy)) {
                            return 1;
                        } else {
                            return s.indexOf(Character.toLowerCase(cx)) - s.indexOf(Character.toLowerCase(cy));
                        }
                    }
                }
            }
            return x.length() - y.length();
        });
        // tr(a);
        for (String e : a) pr(e);
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