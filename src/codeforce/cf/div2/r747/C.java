/**
 * 10/08/21 morning  10/08/21 evening complete
 * https://codeforces.com/contest/1594/problem/C
 */
package codeforce.cf.div2.r747;

import java.util.*;
import java.io.*;

public class C {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1594/submission/131263515
    // WA in Contest
    void solve(int n, char c, String s) {
        // tr(n, c, s);
        char[] a = s.toCharArray();
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] != c) {
                pos.add(i + 1);
            }
        }
        // tr(pos);
        int pn = pos.size();
        if (pn == 0) {
            pr(0);
        } else if (pn == 1) {
            pr(1);
            int x = pos.get(0);
            pr(x == n ? x - 1 : x + 1);
        } else {
            int last = pos.get(pn - 1);
            int sl = pos.get(pn - 2);
            if (last == n) {
//                for (int idx = sl + 1; idx < n; idx++) {  // issue
//                    tr(idx);
//                    if (n % idx != 0) {
//                        pr(1);
//                        pr(idx);
//                        return;
//                    }
//                }
                for (int i = 2; i <= n; i++) { // reference: kmjp
                    boolean ok = true;
                    for (int j = i; j <= n; j += i) {
                        if (a[j - 1] != c) ok = false;
                    }
                    if (ok) {
                        pr(1);
                        pr(i);
                        return;
                    }
                }
                pr(2);
                pr(n + " " + (n - 1));
            } else {
                pr(1);
                pr(n);
            }
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            char c = fs.next().charAt(0);
            String s = fs.next();
            solve(n, c, s);
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