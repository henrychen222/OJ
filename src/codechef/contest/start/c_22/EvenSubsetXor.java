/**
 * 01/19/22 morning
 * https://www.codechef.com/START22C/problems/EVENXOR
 */
package codechef.contest.start.c_22;

import java.util.*;
import java.io.*;

class EvenSubsetXor {
    static PrintWriter pw;
    TreeSet<Integer> ts;

    // Accepted
    void solve(int n) {
//        tr(ts.size(), ts);
        int i = 0;
        int[] res = new int[n];
        for (int x : ts) {
            if (i == n) break;
            res[i] = x;
            i++;
        }
        // tr(res, isSpecial(res));
        outputA(res);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    boolean isSpecial(int[] a) {
        int n = a.length;
        Set<Integer> se = new HashSet<>();
        for (int x : a) se.add(x);
        if (se.size() != n) return false;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> d = new ArrayList<>();
            int xor = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    d.add(a[j]);
                    xor ^= a[j];
                }
            }
            // xor
            tr(d, xor);
            if (isBad(xor)) return false;
        }
        return true;
    }

    boolean isBad(int x) {
        return Integer.bitCount(x) % 2 != 0;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        ts = new TreeSet<>();
        for (int x = 0; x < 1 << 20 && ts.size() < 1000; x++) {
            if (!isBad(x)) ts.add(x);
        }
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new EvenSubsetXor().run();
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
