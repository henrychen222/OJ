/**
 * 10/13/21 morning
 * https://codeforces.com/contest/1593/problem/C
 */

package codeforce.cf.div3.r748;

import java.util.*;
import java.io.*;

public class D1 {

    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1593/submission/131856144
    // reference: Tlatoani
    void solve(int n, int[] a) {
        Set<Integer> se = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int x : a) {
            se.add(x);
            min = Math.min(min, x);
        }
        if (se.size() == 1) {
            pr(-1);
        } else {
            int res = 0;
            for (int x : a) res = gcd(res, x - min);
            pr(res);
        }
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /////////////////////////////////////////////////////////////////////
    void solve1(int n, int[] a) {
        // tr(n, a);
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 1; i < n; i++) {
            int diff = Math.abs(a[i] - a[i - 1]);
            m.put(diff, m.getOrDefault(diff, 0) + 1);
        }
        // tr(m);
        int maxDiff = m.lastKey();
        // tr(maxDiff, m.get(maxDiff));
        if (m.size() == 1) {
            pr(-1);
            return;
        }
        pr(maxDiff / m.get(maxDiff));

//        BigInteger x = new BigInteger(maxDiff + "");
//        BigInteger y = new BigInteger(m.get(maxDiff) + "");
//        BigInteger res = x.divide(y);
//        BigInteger max = new BigInteger(Long.MAX_VALUE + "");
//        int judge = res.compareTo(max);
//        if (judge <= 0) {
//            pr(res.toString());
//        } else {
//            pr(-1);
//        }
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
        new D1().run();
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