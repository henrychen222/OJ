/**
 * 11/05/21 afternoon
 * https://leetcode-cn.com/problems/TJZLyC/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class B1 {
    static PrintWriter pw;

    void solve(int[] a, int[] b) {
        long sum = 0;
        int n = b.length, remove = 0;
        for (int x : a) sum += x;
        for (int k = 0; k <= 1; k++) {
        // for (int e : b) {
            int i = a[k] - 1 - remove;
            int x = a[i];
            int[] l = Arrays.copyOfRange(b, 0, i);
            int[] r = Arrays.copyOfRange(b, i + 1, n);
            tr(l, r);
            remove++;
            n -= remove;
            pr(Math.max(cal(l), cal(r)));
            b = merge(l, r);
        }


        // TreeMap<Integer, Integer> m = new TreeMap<>(Collections.reverseOrder());
//        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
//        for (int idx : b) {
//            int x = a[idx - 1];
//            operate(m, x);
//            tr(m);
//            if (m.size() == 0) {
//                pr(0);
//                return;
//            }
//            int max = m.firstKey();
//            if (m.get(max) >= 2) {
//                pr(2 * max);
//            } else {
//                int i = 0, smax = -1;
//                for (int k : m.keySet()) {
//                    if (i == 1) {
//                        smax = k;
//                        break;
//                    }
//                    i++;
//                }
//                if (smax == -1) {
//                    pr(max);
//                } else {
//                    pr(max + smax);
//                }
//            }
//        }
    }

    int[] merge(int[] a, int[] b) {
        int an = a.length, bn = b.length;
        int[] res = new int[an + bn];
        int i = 0;
        for (; i < an; i++) res[i] = a[i];
        for (; i < bn; i++) res[i] = b[i];
        return res;
    }

    long cal(int[] a) {
        long sum = 0;
        for (int x : a) sum += x;
        return sum;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n), b = fs.readArray(n);
        solve(a, b);
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

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter(System.out);
        new B1().run();
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
