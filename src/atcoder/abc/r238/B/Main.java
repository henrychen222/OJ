/**
 * 02/05/22 morning
 * https://atcoder.jp/contests/abc238/tasks/abc238_b
 */
package atcoder.abc.r238.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    /*
      360
      270 90
      180 90 90
      180 45 45 90
      15 + 45  120 45 45 90
     */
    void solve(int n, int[] a) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        m.put(360, 1);
        for (int r : a) {
            boolean find = false;
            for (int x : m.keySet()) {
                if (x > r) {
                    find = true;
                    addOneMap(m, r);
                    addOneMap(m, x - r);
                    removeOneMap(m, x);
                    break;
                }
            }
            if (!find) {
                int max = m.lastKey();
                for (int x : m.keySet()) {
                    if (x + max > r) {
                        int t1 = r - max + x, t2 = max - t1;
                        // tr(x, "not find", r, m, t1, t2);
                        addOneMap(m, t1);
                        addOneMap(m, t2);
                        removeOneMap(m, max);
                        break;
                    }
                }
            }
            // tr(r, m);
        }
        // tr(m);
        pr(m.lastKey());
    }

    void addOneMap(TreeMap<Integer, Integer> m, int x) {
        m.put(x, m.getOrDefault(x, 0) + 1);
    }

    void removeOneMap(TreeMap<Integer, Integer> m, int x) {
        int occ = m.get(x);
        if (occ > 1) {
            m.put(x, occ - 1);
        } else {
            m.remove(x);
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
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
        new Main().run();
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