/**
 * 04/02/22 morning
 * https://www.codechef.com/COOK140C/problems/RECSTI
 */
package codechef.contest.cook.c_140;

import java.util.*;
import java.io.*;

class SticksRectangles {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/61895914
    // reference: https://discuss.codechef.com/t/recsti-editorial/100347
    void solve(int n, int[] a) {
        if (n == 1) {
            pr(3);
        } else if (n == 2) {
            pr(2);
        } else {
            int[] f = new int[101];
            for (int x : a) f[x]++;
//            int cnt = 0;
            int cnt = n;
            for (int occ : f) cnt += occ % 2;
//            for (int i = 0; i < 101; i++) f[i] %= 4;
//            int one = 0, two = 0, three = 0;
//            for (int occ : f) {
//                if (occ == 0) continue;
//                if (occ == 1) {
//                    one++;
//                } else if (occ == 2) {
//                    two++;
//                } else if (occ == 3) {
//                    three++;
//                }
//            }
//            tr(one, two, three);
//            int cnt = one * 3 + (two % 2) * 2 + three * 1;

            // pr(cnt);
            pr(cnt + cnt % 4 - n);
        }
    }

    int[] removeDuplicatedSorted(int[] a) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int x : a) ts.add(x);
        int[] res = new int[ts.size()];
        int p = 0;
        for (int x : ts) res[p++] = x;
        return res;
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
        new SticksRectangles().run();
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