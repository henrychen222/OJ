/**
 * 02/15/22 evening
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000008f4332/0000000000941e56
 */
package kickstart.y2022.practice.round1.B;

import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter pw;

    // Pass 1  TLE 2
    void solve(int n, int[] a) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(a[i]);
            int ans = hIndex(l);
            pw.print(ans + " ");
        }
        pr("");
    }

    int hIndex(List<Integer> l) {
        int n = l.size();
        int[] f = new int[n + 1];
        for (int c : l) {
            if (c >= n) {
                f[n]++;
            } else {
                f[c]++;
            }
        }
//        tr(f);
        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += f[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}

