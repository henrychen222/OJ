/**
 * 02/21/22 morning
 * https://www.codechef.com/COOK138C/problems/PREFPERM
 */
package codechef.contest.cook.c_138;

import java.util.*;
import java.io.*;

class PrefixPermutation {
    static PrintWriter pw;

    // Accepted (don't know why this first version is wrong)
    void solve(int n, int k, int[] a) {
        int[] res = new int[n];
        int p = 0, pre = 1;
        for (int x : a) {
            for (int i = x; i >= pre; i--) {
                res[p++] = i;
            }
            pre = x + 1;
        }
        // tr(test(res, a));
        outputA(res);
    }

    // WA
    void solve1(int n, int k, int[] a) {
        int[] res = new int[n];
        int p = 0, cur = 1;
        for (int x : a) {
            for (int i = p; i < x; i++) {
                res[p++] = cur++;
            }
        }
        tr(test(res, a));
        outputA(res);
    }

    boolean test(int[] res, int[] a) {
        for (int x : a) {
            int[] sub = Arrays.copyOfRange(res, 0, x);
            Arrays.sort(sub);
            for (int i = 0; i < sub.length; i++) {
                if (sub[i] != i + 1) return false;
            }
        }
        return true;
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
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
        new PrefixPermutation().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
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

