/**
 * 10/31/21 night
 * https://codeforces.com/problemset/problem/109/A
 */
package codeforce.practice.L1000;

import java.util.*;
import java.io.*;

public class A109 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/109/133882797
    /*
       x * 4 + y * 7 = n
     */
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        boolean found1 = false, found2 = false;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (; y1 * 7 <= n; y1++) {
            int rest = n - y1 * 7;
            if (rest % 4 == 0) {
                x1 = rest / 4;
                found1 = true;
                break;
            }
        }
        for (; x2 * 4 <= n; x2++) {
            int rest = n - x2 * 4;
            if (rest % 7 == 0) {
                y2 = rest / 7;
                found2 = true;
                break;
            }
        }
        // tr(x1, y1, x2, y2);
        String res1 = "4".repeat(x1) + "7".repeat(y1);
        String res2 = "4".repeat(x2) + "7".repeat(y2);
        if (found1) {
            if (found2) {
                if ((x1 + y1) < (x2 + y2)) {
                    pr(res1);
                } else if ((x1 + y1) > (x2 + y2)) {
                    pr(res2);
                } else {
                    if (x1 < x2) {
                        pr(res1);
                    } else {
                        pr(res2);
                    }
                }
            } else {
                pr(res1);
            }
        } else {
            if (found2) {
                pr(res2);
            } else {
                pr(-1);
            }
        }
    }

//    boolean isEqual(String s, int t) {
//        int sum = 0;
//        for (int i = 0; i < s.length(); i++) sum += s.charAt(i) - '0';
//        return sum == t;
//    }
//
//    boolean isLucky(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c != '4' && c != '7') return false;
//        }
//        return true;
//    }

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
        new A109().run();
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