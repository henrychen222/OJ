/**
 * 09/20/21 morning
 * https://codeforces.com/contest/1574/problem/B
 */
package codeforce.ecf.r114;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    void solve(int a, int b, int c, int m) {
        int max = (a - 1) + (b - 1) + (c - 1);
        if (max < m) {
            pr("NO");
        } else if (max == m) {
            pr("YES");
        } else { // min pair is has to minus large first (greedy), wrong
            int[] t = {a, b, c};
            Arrays.sort(t);
//            t[2] -= t[1] - t[0];
//            int minPair = t[2] - 1;
            int minPair = Math.max(0, t[2] - 1 - t[0] - t[1]);
            pr(minPair <= m ? "YES" : "NO");
        }
    }

    /*
     AAAAA  4 pair
     ABAAAA 3 pair
     */
    void solve1(int a, int b, int c, int m) {
        int max = (a - 1) + (b - 1) + (c - 1);
        if (max < m) {
            pr("NO");
        } else if (max == m) {
            pr("YES");
        } else { // 2 2 2 min can be 0, -> 1 1 2 -> 0 1 1 -> 0 0 0    Now is -> 0 0 2
            int[] t = {a, b, c};
            Arrays.sort(t);
            // tr(t);
            t[2] -= t[1];
            t[1] = 0;
            int pair = 0;
            for (int x : t) {
                if (x > 0) pair += x - 1;
            }
            // tr("first", t, pair);
            if (pair <= m) {
                pr("YES");
                return;
            }
            Arrays.sort(t);
            t[2] -= t[1];
            t[1] = 0;
            pair = 0;
            for (int x : t) {
                if (x > 0) pair += x - 1;
            }
            // tr("second", t, pair);
            if (pair <= m) {
                pr("YES");
                return;
            }
            pr("NO");
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            int m = fs.nextInt();
            solve(a, b, c, m);
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


//            int[] t = {a - 1, b - 1, c - 1}; // max pair
//            Arrays.sort(t);
//            // tr(t);
//            int needRemove = max - m;
//            int remove12 = (t[1] + 1) * 2;
//            // tr("remove12", remove12);
//            if (remove12 >= needRemove) {
//                pr("YES");
//                return;
//            }
//            needRemove -= remove12;
//            t[2] -= t[1] + 1;
//            t[1] = 0;
//            // tr("new", t);
//            int remove02 = Math.min(t[0] + 1, t[2] + 1) * 2;
//            // tr("remove02", remove02);
//            if (remove02 >= needRemove) {
//                pr("YES");
//                return;
//            }
//            pr("NO");