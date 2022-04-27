/**
 * 02/09/22 morning
 * https://www.codechef.com/START25B/problems/EQUALMEX
 */
package codechef.contest.start.b_25;

import java.util.*;
import java.io.*;

class EqualMEX {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/58149102
    // reference: https://www.codechef.com/viewsolution/58049599
    void solve(int n, int[] a) {
        int h = n / 2;
        int[] f = new int[h + 1];
        for (int x : a) f[x]++;
        // tr(f);
        for (int i = 0; i <= h; i++) {
            int occ = f[i];
            if (occ == 1) {
                pr("NO");
                return;
            } else if (occ == 0) {
                pr("YES");
                return;
            }
        }
    }

    ///////////////////////////////////////////
    /*
     2
     0 2 0 3
     2
     0 2 3 4
     */
    // WA
    void solve1(int n, int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        boolean ok = true;
        int cnt = n / (n / 2);
        for (int x : m.values()) {
            if (x != cnt) {
                ok = false;
                break;
            }
        }
        if (ok) {
            pr("YES");
            return;
        }
        int max = m.lastKey(), miss = 0;
        for (int i = 0; i <= max; i++) {
            if (!m.containsKey(i)) {
                miss++;
            }
        }
        pr(miss == 1 ? "YES" : "NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n * 2);
            solve(n * 2, a);
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
        new EqualMEX().run();
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