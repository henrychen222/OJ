/**
 * 02/21/22 morning
 * https://www.codechef.com/COOK138C/problems/HOLIDAYS
 */
package codechef.contest.cook.c_138;

import java.util.*;
import java.io.*;

class PerfectPermutation {
    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/58830031
    void solve(int n, int k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i + 1;
//        if (k == 1) {
//            if (n % 2 == 0) {
//            } else {
//                a[0] = 1;
//                int p = 1;
//                for (int i = n; i > 1; i--) a[p++] = i;
//            }
//            tr("k = 1", ct(a), k, a);
//            if (ct(a) == k) {
//                outputA(a);
//                return;
//            }
//        }
        // tr("ans", ct(a), k, a);
        int diff = n - k;
        if (diff % 2 == 0) {
            for (int i = 1; i + 1 < n && diff != 0; i += 2) { // fuck bug here i = 1  not i = 2    (case 13 1)
                swap(a, i, i + 1);
                diff -= 2;
            }
        } else {
            swap(a, 0, 1);
            diff--;
            for (int i = 2; i + 1 < n && diff != 0; i += 2) {
                swap(a, i, i + 1);
                diff -= 2;
            }
        }
        // tr("ans", ct(a), k, a);
        if (ct(a) != k) {
            pr(-1);
        } else {
            outputA(a);
        }
    }

    // WA
    void solve1(int n, int k) {
        int[] a = new int[n];
        int p = 0;
        for (int i = 0; i < k; i++) a[p++] = i + 1;
        for (int i = n; i > k; i--) {
            a[p++] = i;
        }
        // tr("ans", a, ct(a), k);
        int cnt = ct(a);
        if (cnt > k) {
            int diff = cnt - k;
            for (int i = 1, t = 1; i + 1 < n && t <= diff; i += 2, t++) swap(a, i, i + 1);
        }
        // tr("ans", a, ct(a), k);
        if (ct(a) != k) {
            pr(-1);
        } else {
            outputA(a);
        }
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    int[] reverseA(int[] a) {
        int n = a.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = a[n - i - 1];
        return b;
    }

    int ct(int[] a) {
        int cnt = 0, n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] % (i + 1) == 0) cnt++;
        }
        return cnt;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt(), k = fs.nextInt();
            solve(n, k);
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
        new PerfectPermutation().run();
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

