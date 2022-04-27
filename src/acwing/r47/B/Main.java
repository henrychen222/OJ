/**
 * 04/16/22 morning
 * https://www.acwing.com/problem/content/4403/
 */
package acwing.r47.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int k, int[] a) {
        int[] res = new int[k];
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < n; i++) d.add(i + 1);
        int cur = 1, idx = 0;
        for (int i = 0; i < k; i++) {
            int rem = a[i] % d.size();
            idx += rem;
            idx %= d.size();
            res[i] = d.get(idx);
            if (idx + 1 < d.size()) {
                cur = d.get(idx + 1);
            } else {
                cur = d.get(0);
            }
            d.remove(idx);
            idx = indexOf(d, cur);
            // tr("cur", cur, "idx", idx, d);
        }
        outputA(res);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    int indexOf(List<Integer> a, int x) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            if (a.get(i) == x) return i;
        }
        return -1;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(k);
        solve(n, k, a);
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