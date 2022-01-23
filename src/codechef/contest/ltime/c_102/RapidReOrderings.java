/**
 * 11/27/21 morning
 * https://www.codechef.com/LTIME102C/problems/RPDRDNG
 */
package codechef.contest.ltime.c_102;

import java.util.*;
import java.io.*;

// just 3 minutes more needs (shit)  only 1 hour left start from 11am, start from 9am
class RapidReOrderings {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/54434121
    void solve(int N, int[] b) {
        TreeMap<Integer, Integer> mb = new TreeMap<>();
        for (int x : b) mb.put(x, mb.getOrDefault(x, 0) + 1);
        int n = mb.size();
        int[] a = new int[n];
        int idx = 0;
        for (int x : mb.keySet()) {
            a[idx] = x;
            idx++;
        }
        // tr(a);
        TreeMap<Integer, Integer> ma = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int len = i + 1;
            int m = len % 2 == 0 ? len / 2 - 1 : len / 2;
            // tr(m, Arrays.copyOfRange(a, 0, i + 1), len, a[m]);
            ma.put(a[m], ma.getOrDefault(a[m], 0) + 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            int len = n - 1 - i + 1;
            int m = len % 2 == 0 ? i + len / 2 - 1 : i + len / 2;
            ma.put(a[m], ma.getOrDefault(a[m], 0) + 1);
        }
//        tr("b,", mb);
//        tr("a", ma);
        for (int k : ma.keySet()) {
            int occ = ma.get(k), bocc = mb.getOrDefault(k, 0);
            if (occ != bocc) {
                pr(-1);
                return;
            }
        }
        output(a);
    }

    void output(int[] a) {
        for (int e : a) {
            pw.print(e + " ");
        }
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] b = fs.readArray(2 * n);
            solve(n, b);
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
        new RapidReOrderings().run();
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