/**
 * 12/12/21 morning
 * https://codeforces.com/contest/1591/problem/C
 */
package codeforce.cf.div2.r759;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/contest/1591/submission/138973450  (12/13/21 morning)
    // reference wifi
    void solve(int n, int k, int[] a) {
        List<Integer> pos = new ArrayList<>(Arrays.asList(0)), neg = new ArrayList<>(Arrays.asList(0));
        for (int x : a) {
            if (x > 0) {
                pos.add(x);
            } else if (x < 0) {
                neg.add(-x);
            }
        }
        Collections.sort(pos);
        Collections.sort(neg);
        long res = solve(pos, k) + solve(neg, k) - Math.max(pos.get(pos.size() - 1), neg.get(neg.size() - 1));
        pr(res);
    }

    long solve(List<Integer> a, int k) { // calculate each k distance
        if (a.size() == 0) return 0;
        long sum = 0;
        for (int i = a.size() - 1; i >= 0; i -= k) sum += a.get(i) * 2L;
        return sum;
    }

    ////////////////////////////////////////////////////
    // Wrong
    void solve1(int n, int k, int[] a) {
        shuffleArray(a);
        Arrays.sort(a);
        // tr(a);
        long res = 0, cur = 0, pre = 0;
        for (int i = 0, t = 1; i < n; i++, t++) {
            // tr("cur", cur, "res", res);
            cur = a[i];
            if (t % k == 0) {
                res += Math.abs(cur - pre);
                pre = 0;
            }
            res += Math.abs(cur - pre);
            pre = cur;
        }
        // tr(cur);
        pr(res + Math.abs(cur));
    }

    void shuffleArray(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int randomPos = i + rnd.nextInt(n - i);
            a[i] = a[randomPos];
            a[randomPos] = tmp;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            int[] a = fs.readArray(n);
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