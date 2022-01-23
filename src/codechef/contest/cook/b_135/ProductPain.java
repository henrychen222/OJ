/**
 * 11/21/21 morning
 * https://www.codechef.com/COOK135B/problems/PRDTPAIN
 */

package codechef.contest.cook.b_135;

import java.util.*;
import java.io.*;

class ProductPain {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/54149134
    // reference: https://www.codechef.com/viewsolution/54149134
    void solve(int n, int[] a) {
        long res = 0;
        for (int l = 0; l < n; l++) {
            int mid = l + 1;
            for (int r = l + 2; r < n; r++) {
                while (mid < r - 1) { // get max mid
                    long t1 = cal(l, mid, r, a), t2 = cal(l, mid + 1, r, a);
                    if (t1 > t2) {
                        break;
                    }
                    mid++;
                }
                res += cal(l, mid, r, a);
            }
        }
        pr(res);
    }

    long cal(int l, int mid, int r, int[] a) {
        return (long) (a[mid] - a[l]) * (a[r] - a[mid]);
    }

    /*
     1107 + 10812 + 407011 + 4293 + 333498 + 285087
     */
    // WA
    void solve1(int n, int[] a) {
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len < 3) continue;
                int f = a[i], l = a[j];
                if (len % 2 == 0) {
                    int right = a[i + len / 2];
                    int left = a[i + len / 2 - 1];
                    long t1 = (long) (left - f) * (l - left);
                    long t2 = (long) (right - f) * (l - right);
                    // tr("even", f, l, "left", left, "right", right, Arrays.copyOfRange(a, i, j + 1), t1, t2);
                    res += Math.max(t1, t2);
                } else {
                    int middle = a[i + len / 2];
                    int left = a[i + len / 2 - 1];
                    int right = a[i + len / 2 + 1];
                    long t = (long) (middle - f) * (l - middle);
                    long t1 = (long) (left - f) * (l - left);
                    long t2 = (long) (right - f) * (l - right);
                    // tr("odd", f, l, "middle", middle, Arrays.copyOfRange(a, i, j + 1), t);
                    res += Math.max(t, (Math.max(t1, t2)));
                }
            }
        }
        pr(res);
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
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
        new ProductPain().run();
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