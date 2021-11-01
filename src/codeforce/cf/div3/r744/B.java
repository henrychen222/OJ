/**
 * 09/28/21 morning  09/29/21 evening complete
 * https://codeforces.com/contest/1579/problem/B
 */
package codeforce.cf.div3.r744;

import java.util.*;
import java.io.*;

public class B {

    static PrintWriter pw;

    // Accepted https://codeforces.com/contest/1579/submission/130306294
    // reference: cuiaoxiang
    void solve(int n, int[] a) {
        // tr(n, a);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int min = a[i], bestJ = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < min) {
                    min = a[j];
                    bestJ = j;
                }
            }
            if (bestJ == i) continue;
            int tmp = a[bestJ];
            for (int k = bestJ; k > i; k--) a[k] = a[k - 1];
            a[i] = tmp;
            res.add(new int[]{i, bestJ, bestJ - i});
            // tr(a);
        }
        pr(res.size());
        output(res);
    }

    void output(List<int[]> l) {
        for (int[] a : l) {
            String tmp = "";
            for (int i = 0; i < 3; i++) {
                tmp += (i == 2 ? a[i] : a[i] + 1);
                tmp += " ";
            }
            pr(tmp);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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