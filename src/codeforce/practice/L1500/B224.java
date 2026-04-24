/**
 * 04/16/26 night
 * https://codeforces.com/problemset/problem/224/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B224 {
    static PrintWriter pw;

    // Accepted --- https://codeforces.com/problemset/submission/224/371466715
    void solve(int n, int k, int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, minLen = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        // sliding window for distinct element k
        for (int i = 0; i < n; i++) {
            m.merge(a[i], 1, Integer::sum);
            while (m.size() > k) {
                removeOneOrManyMap(m, a[l++]);
            }
            while (m.size() == k) { // shrink left to min length
                int len = i - l + 1;
                if (len < minLen) {
                    minLen = len;
                    res[0] = l + 1;
                    res[1] = i + 1;
                }
                removeOneOrManyMap(m, a[l++]);
            }
            // Adjust after shrinking too much: Restore the last removal to maintain correct state for next iteration
            if (l > 0 && m.size() == k - 1) {
                l--;
                m.merge(a[l], 1, Integer::sum);
            }
        }
        pr(res[0] + " " + res[1]);
    }

    <T> void removeOneOrManyMap(Map<T, Integer> m, T x, int... args) {
        int cnt = args.length == 0 ? 1 : args[0];
        m.merge(x, -cnt, Integer::sum);
        if (m.get(x) == 0) {
            m.remove(x);
        }
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), k = fs.nextInt();
        int[] a = fs.readArray(n);
        solve(n, k, a);
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
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B224().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ignored) {
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