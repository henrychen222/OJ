/**
 * 10/13/21 morning  10/30/21 afternoon fix
 * https://codeforces.com/contest/1593/problem/C
 */

package codeforce.cf.div3.r748;

import java.util.*;
import java.io.*;

public class C {

    static PrintWriter pw;

    // Accepted https://codeforces.com/contest/1593/submission/133698562
    void solve(int n, int k, int[] a) {
        // tr(n, k, a);
        TreeMap<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        int cat = 0, res = 0;
        for (int x : m.keySet()) {
            if (cat >= x) break;
            int step = n - x;
            int t = m.get(x);
            // WA: https://codeforces.com/contest/1593/submission/131808885 forget to cast long // WA after contest rejudge system test
            // long allSteps = t * step;
            long allSteps = (long) t * step;
            if (cat + allSteps < x) {
                // tr("1111");
                cat += allSteps;
                res += t;
            } else {
                // tr("3333");
                int can = 0;
                while (cat < x) {
                    can++;
                    cat += step;
                }
                res += can;
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] a = fs.readArray(k);
            solve(n, k, a);
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
        new C().run();
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