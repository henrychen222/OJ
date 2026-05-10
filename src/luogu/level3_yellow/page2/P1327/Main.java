/**
 * 05/07/26 afternoon
 * https://www.luogu.com.cn/problem/P1327
 * similar problem:
 * https://codeforces.com/problemset/problem/53/D
 */
package luogu.level3_yellow.page2.P1327;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/277057576
    void solve(int n, int[] a) {
        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) m.put(a[i], i);
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                int j = m.get(b[i]);
                swapWithMapDistinctArray(a, i, j, m);
//                tr(m, a, b);
                res++;
            }
        }
        pr(res);
    }

    void swapWithMapDistinctArray(int[] a, int i, int j, Map<Integer, Integer> m) {
        m.put(a[i], j);
        m.put(a[j], i);
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, a);
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}