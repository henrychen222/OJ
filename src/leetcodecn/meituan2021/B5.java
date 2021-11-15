/**
 * 11/11/21 noon
 * https://leetcode-cn.com/problems/yqj8Su/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class B5 {
    static PrintWriter pw;

    // Accepted --- 112ms 100%
    // reference: https://leetcode-cn.com/problems/yqj8Su/solution/yue-du-li-jie-hou-jiu-shi-yi-ge-po-shi-w-8dnc/
    // 题解 https://leetcode-cn.com/problems/yqj8Su/solution/java-binary-search-112ms-100-by-coffeehe-6as5/
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int m = fs.nextInt(), n = fs.nextInt(), res = 0;
        int[] a = fs.readArray(n);
        for (int i = 1; i <= m; i++) {
            int low = i, high = m + 1;
            while (low < high) {
                int mid = low + high >>> 1;
                if (ok(i, mid, n, a)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            res += m - low + 1;
            if (low == m + 1) break;
        }
        pr(res);
    }

    boolean ok(int l, int r, int n, int[] a) {
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (l > a[i] || r < a[i]) {
                if (a[i] < pre) return false;
                pre = a[i];
            }
        }
        return true;
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
        new B5().run();
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
