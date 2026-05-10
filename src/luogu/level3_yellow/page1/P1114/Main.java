/**
 * 05/05/26 noon 05/06/26 night
 * https://www.luogu.com.cn/problem/P1114
 *
 * same problem:
 * https://leetcode.com/problems/contiguous-array/
 */
package luogu.level3_yellow.page1.P1114;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/276976172
    int maxLengthSubarrayWithEqual01(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) a[i] = -1;
        }
        Map<Long, Integer> m = new HashMap<>(Map.of(0L, -1));
        long sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (m.containsKey(sum)) {
                int preIdx = m.get(sum), len = i - preIdx;
                res = Math.max(res, len);
            } else {
                m.put(sum, i);
            }
        }
        return res;
    }

    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = fs.readArray(n);
        pr(maxLengthSubarrayWithEqual01(a));
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