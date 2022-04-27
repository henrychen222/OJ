/**
 * 03/12/22 morning
 * https://www.acwing.com/problem/content/4315/
 */
package acwing.r42.B;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // After Contest Accepted
    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int n = fs.nextInt(), m = fs.nextInt(), q = fs.nextInt();
        String s = fs.next(), t = fs.next();
        List<int[]> a = findAllMatchIndexRange(s, t);
        for (int i = 0; i < q; i++) {
            int l = fs.nextInt() - 1, r = fs.nextInt() - 1;
            int cnt = 0;
            for (int[] range : a) {
                if (range[0] >= l && range[1] <= r) cnt++;
            }
            pr(cnt);
        }
    }

    List<int[]> findAllMatchIndexRange(String s, String t) {
        int n = s.length(), m = t.length();
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                if (i + m <= n) {
                    String subS = s.substring(i, i + m);
                    if (subS.equals(t)) {
                        int r = i + m - 1;
                        int[] range = new int[]{i, r};
                        a.add(range);
                    }
                }
            }
        }
        // debugArrayInList(a);
        return a;
    }

    void debugArrayInList(List<int[]> l) {
        int[][] res = new int[l.size()][];
        for (int i = 0; i < l.size(); i++) res[i] = l.get(i);
        tr("out", res);
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