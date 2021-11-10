/**
 * 11/06/21 night
 * https://leetcode-cn.com/problems/GXV5dX/
 */
package leetcodecn.meituan2021;

import java.util.*;
import java.io.*;

public class A2 {
    static PrintWriter pw;

    // Accepted --- 208ms 77.03%
    // 题解 https://leetcode-cn.com/problems/GXV5dX/solution/java-treemap-208ms-7703-by-coffeehenry-3t1z/
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt();
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>(Collections.reverseOrder());
        for (int i = 1; i <= n; i++) {
            int v = fs.nextInt(), w = fs.nextInt();
            int profit = v + w * 2;
            if (!tm.containsKey(profit)) tm.put(profit, new ArrayList<>());
            tm.get(profit).add(i);
        }
        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        for (int k : tm.keySet()) {
            List<Integer> a = tm.get(k);
            int len = a.size();
            if (cnt + len <= m) {
                res.addAll(a);
                if (cnt + len == m) break;
            } else {
                int need = m - cnt;
                for (int i = 0; i < need; i++) res.add(a.get(i));
                break;
            }
            cnt += len;
        }
        Collections.sort(res);
        output(res);
    }

    void output(List<Integer> a) {
        for (int e : a) {
            pw.print(e + " ");
        }
        pr("");
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
        new A2().run();
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
