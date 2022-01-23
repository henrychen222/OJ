/**
 * 12/10/21 night
 * https://codeforces.com/contest/1608/problem/B
 */
package codeforce.cf.div2.r758;

import java.util.*;
import java.io.*;

// read: https://codeforces.com/blog/entry/97782
public class B {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1608/submission/138989376 (12/13/21 morning)
    // reference: kmjp
    void solve(int n, int a, int b) {
        if (a + b > n - 2 || Math.abs(a - b) > 1) {
            pr(-1);
            return;
        }
        List<Integer> t = new ArrayList<>();
        if (a == b) {
            for (int i = 0; i < a; i++) {
                t.add(i + 1);
                t.add(n - i);
            }
            for (int i = 0; i < n - 2 * a; i++) t.add(a + 1 + i);
        } else if (a - b == 1) {
            for (int i = 0; i < a; i++) {
                t.add(i + 1);
                t.add(n - i);
            }
            for (int i = 0; i < n - 2 * a; i++) t.add(n - a - i);
        } else if (b - a == 1) {
            for (int i = 0; i <= a; i++) {
                t.add(n - i);
                t.add(i + 1);
            }
            for (int i = 0; i < n - (2 * a + 2); i++) t.add(a + 2 + i);
        }
        outputL(t);
    }

    /////////////////////////////////////////////////////////////
    /*
        a b
      1 3 2 4

        b a b
      4 2 3 1 5 6
     */
    // WA
    void solve1(int n, int a, int b) {
//        if (Math.abs(a - b) > 1) {
//            pr(-1);
//            return;
//        }
        TreeSet<Integer> ts = new TreeSet<>();
        int max = Math.max(a, b);
        int m = max % 2 == 0 ? max * 2 : max * 2 + 1;
        for (int i = 1; i <= m; i++) ts.add(i);
        List<Integer> t1 = new ArrayList();
        List<Integer> t2 = new ArrayList();
        if (ts.size() % 2 == 0) {
            while (ts.size() > 0) {
                int small = ts.pollFirst(), large = ts.pollLast();
                t1.add(small);
                t1.add(large);
                t2.add(large);
                t2.add(small);
            }
        } else {
//            tr("odd");
            while (ts.size() > 1) {
                int small = ts.pollFirst(), large = ts.pollLast();
                t1.add(small);
                t1.add(large);
                t2.add(large);
                t2.add(small);
            }
            int last = ts.pollFirst();
            t1.add(last);
            t2.add(last);
        }
//        tr("first step", t1, t2, m);
        for (int rest = m + 1; rest <= n; rest++) {
            t1.add(rest);
            t2.add(rest);
        }
//        tr("second step", t1, t2);
//        tr(test(t1, n, a, b), test(t2, n, a, b));
        if (test(t1, n, a, b)) {
            outputL(t1);
            return;
        }
        if (test(t2, n, a, b)) {
            outputL(t2);
            return;
        }
        pr(-1);
    }

    boolean test(List<Integer> t, int n, int a, int b) {
        int A = 0, B = 0;
        for (int i = 1; i < n - 1; i++) {
            if (t.get(i) > t.get(i - 1) && t.get(i) > t.get(i + 1)) A++;
            if (t.get(i) < t.get(i - 1) && t.get(i) < t.get(i + 1)) B++;
        }
        tr(A, B);
        return A == a && B == b;
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(3);
            solve(a[0], a[1], a[2]);
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