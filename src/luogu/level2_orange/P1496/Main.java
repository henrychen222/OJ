/**
 * 11/12/21 afternoon
 * https://www.luogu.com.cn/problem/P1496
 */
package luogu.level2_orange.P1496;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62391677
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) a[i] = fs.readArray(2);
        List<int[]> d = mergeIntervals(a);
        int res = 0;
        for (int[] e : d) res += e[1] - e[0];
        pr(res);
    }

    List<int[]> mergeIntervals(int[][] a) { // 并集
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{a[0][0], a[0][1]});
        int preEnd = a[0][1];
        for (int[] b : a) {
            int start = b[0], end = b[1];
            if (start > preEnd) {
                res.add(new int[]{start, end});
                preEnd = end;
            } else {
                int[] pre = res.get(res.size() - 1);
                res.remove(res.size() - 1);
                int left = Math.min(pre[0], start); // 并集左边求小，右边求大
                int right = Math.max(pre[1], end);
                res.add(new int[]{left, right});
                preEnd = right;
            }
        }
//        int[][] debug = new int[res.size()][];
//        for (int i = 0; i < res.size(); i++) debug[i] = res.get(i);
//        tr("out", debug);
        return res;
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