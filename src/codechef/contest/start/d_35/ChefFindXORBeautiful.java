/**
 * 04/20/22 morning
 * https://www.codechef.com/START35D/problems/CFXORB
 */
package codechef.contest.start.d_35;

import java.util.*;
import java.io.*;

class ChefFindXORBeautiful {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/63347504
    /*
       reference:
       https://www.codechef.com/viewsolution/63275097
       https://discuss.codechef.com/t/cfxorb-editorial/100726
       (A[i] ^ A[j]) & x == 0
     => (A[i] & x) ^ (A[j] & x) == 0
     => (A[i] & x) == (A[j] & x)    (a ^ b) == 0 means a == b
     */
    void solve(int n, int x, int[] a) {
        // tr(n, x, a);
        // pr(test(n, x, a));
        long res = 0;
        int[] and = new int[n];
        for (int i = 0; i < n; i++) and[i] = a[i] & x;
        // tr(and);
        Map<Integer, Integer> m = counter(and);
        for (int occ : m.values()) res += (long) occ * occ;
        pr(res);
    }

    // TLE https://www.codechef.com/viewsolution/63297723
    long test(int n, int x, int[] a) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long t = (long) (a[i] ^ a[j]) & x;
                // tr(a[i], a[j], "xor", a[i] ^ a[j], "x", x, "t", t);
                if (t == 0) res += (i == j ? 1 : 2);
            }
        }
        return res;
    }

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int x = fs.nextInt();
            solve(n, x, a);
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
        new ChefFindXORBeautiful().run();
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
