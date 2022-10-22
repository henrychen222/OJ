/**
 * 01/19/22 evening 06/23/22 afternoon complete
 * https://www.codechef.com/LTIME01/problems/NUMFACT
 */
package codechef.contest.ltime.r01;

import java.util.*;
import java.io.*;

class NumberFactors {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/67461009
    // reference: https://www.codechef.com/viewsolution/2302759
    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> f = new TreeMap<>();
        for (int x : a) factor(f, x);
        // tr(f);
        long res = 1;
        for (int occ : f.values()) res *= occ + 1;
        pr(res);
    }

    void factor(TreeMap<Integer, Integer> m, int n) {
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                m.put(i, m.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) m.put(n, m.getOrDefault(n, 0) + 1);
    }

    // TLE https://www.codechef.com/viewsolution/67459403
    void solve1(int n, int[] a) {
        int p = 1;
        for (int x : a) p *= x;
        pr(findAllFactors(p).size());
    }

    TreeSet<Integer> findAllFactors(int n) {
        TreeSet<Integer> res = new TreeSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    res.add(i);
                } else {
                    res.add(i);
                    res.add(n / i);
                }
            }
        }
        return res;
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
        new NumberFactors().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}