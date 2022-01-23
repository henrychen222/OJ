/**
 * 01/05/22 morning
 * https://www.codechef.com/START21C/problems/ANDORUNI
 */
package codechef.contest.start.c_21;

import java.util.*;
import java.io.*;

class AndUnion {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/55910449
    // reference: https://www.codechef.com/viewsolution/55858893
    // read: https://discuss.codechef.com/t/andoruni-editorial/97495
    void solve(int n, int[] a) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int x : a) {
                if ((x & (1 << i)) > 0) cnt++;
            }
            if (cnt >= 2) res |= 1 << i;
        }
        pr(res);
    }

    // TLE
    void solve1(int n, int[] a) {
        int bn = n * (n - 1) / 2;
        int[] b = new int[bn];
        int p = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                b[p++] = a[i] & a[j];
            }
        }
        // tr(b);
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : b) m.put(x, m.getOrDefault(x, 0) + 1);
//        while (true) {
//            if (m.size() == 1 && m.values().iterator().next() == 1) break;
//            int min = m.firstKey(), max = m.lastKey(), add = min | max;
//            removeOneMap(m, min);
//            removeOneMap(m, max);
//            m.put(add, m.getOrDefault(add, 0) + 1);
//        }
        while (true) {
            // tr(m);
            if (m.size() == 1 && m.values().iterator().next() == 1) break;
            int min = m.firstKey(), max = m.lastKey(), add = min | max;
            int minF = m.get(min), maxF = m.get(max);
            if (minF < maxF) {
                m.remove(min);
                m.put(max, maxF - minF);
                m.put(add, m.getOrDefault(add, 0) + minF);
            } else if (minF > maxF) {
                m.remove(max);
                m.put(min, minF - maxF);
                m.put(add, m.getOrDefault(add, 0) + maxF);
            } else {
                m.remove(min);
                m.remove(max);
                m.put(add, m.getOrDefault(add, 0) + minF);
            }
        }
        pr(m.keySet().iterator().next());
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
        new AndUnion().run();
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