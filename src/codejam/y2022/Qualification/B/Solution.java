/**
 * 04/01/22 evening
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1/0000000000a4672b
 */
package codejam.y2022.Qualification.B;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;
    private int need = (int) 1e6;

    // Accepted
    void solve(int[] a, int[] b, int[] c) {
        // tr(a, b, c);
        int[] d = new int[4];
        for (int i = 0; i < 4; i++) d[i] = Math.min(a[i], Math.min(b[i], c[i]));
        // tr("d", d);
        int sum = 0;
        for (int x : d) sum += x;
        if (sum < need) {
            pr("IMPOSSIBLE");
        } else if (sum == need) {
            outputA(d);
        } else {
            int remove = sum - need;
            // tr(d, remove);
            for (int i = 0; i < 4; i++) {
                if (d[i] - remove >= 0) {
                    d[i] -= remove;
                    break;
                } else {
                    remove -= d[i];
                    d[i] = 0;
                }
            }
            outputA(d);
        }
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        for (int cas = 1; cas <= t; cas++) {
            pw.print("Case #" + cas + ": ");
            int[] a = fs.readArray(4), b = fs.readArray(4), c = fs.readArray(4);
            solve(a, b, c);
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}