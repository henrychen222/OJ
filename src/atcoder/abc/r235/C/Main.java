/**
 * 01/15/22 morning
 * https://atcoder.jp/contests/abc235/tasks/abc235_c
 */
package atcoder.abc.r235.C;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), q = fs.nextInt();
        int[] a = fs.readArray(n);
        Map<Integer, ArrayList<Integer>> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = a[i];
            if (!m.containsKey(x)) m.put(x, new ArrayList<>());
            m.get(x).add(i + 1);
        }
        // tr(m);
        while (q-- > 0) {
            int x = fs.nextInt(), k = fs.nextInt();
            if (m.containsKey(x)) {
                List<Integer> l = m.get(x);
                if (k - 1 < l.size()) {
                    pr(l.get(k - 1));
                } else {
                    pr(-1);
                }
            } else {
                pr(-1);
            }
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