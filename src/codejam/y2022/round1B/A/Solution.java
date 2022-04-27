/**
 * 04/24/22 afternoon
 * https://codingcompetitions.withgoogle.com/codejam/round/000000000087711b/0000000000acd59d
 */
package codejam.y2022.round1B.A;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Accepted
    // reference: neal_wu
    void solve1(int n, int[] a) {
        int max = 0, i = 0, j = n - 1, res = 0;
        while (i <= j) {
            if (a[i] <= a[j]) {
                res += a[i] >= max ? 1 : 0;
                max = Math.max(max, a[i]);
                i++;
            } else {
                res += a[j] >= max ? 1 : 0;
                max = Math.max(max, a[j]);
                j--;
            }
            // tr("i", i, a[i], "j", j, a[j], "res", res);
        }
        pr(res);
    }

    //////////////////////////////////////////////////////
    void solve(int n, int[] a) {
        List<Integer> d = new ArrayList<>();
        int i, j;
        if (a[0] <= a[n - 1]) {
            d.add(a[0]);
            i = 1;
            j = n - 1;
        } else {
            d.add(a[n - 1]);
            i = 0;
            j = n - 2;
        }
        // tr(d, i, j);
        while (i <= j) {
            int pre = d.get(d.size() - 1);
            if (a[i] >= pre) {
                if (a[j] >= pre) {
                    if (a[i] <= a[j]) {
                        d.add(a[i++]);
                    } else {
                        d.add(a[j--]);
                    }
                } else {
                    d.add(a[i++]);
                }
            } else {
                if (a[j] >= pre) {
                    d.add(a[j--]);
                } else {
                    break;
                }
            }
            // tr(d, i, j);
        }
        // tr(d);
        pr(d.size());
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            solve(n, a);
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
        new Solution().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}