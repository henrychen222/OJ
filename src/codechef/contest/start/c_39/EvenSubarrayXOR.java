/**
 * 05/18/22 morning
 * https://www.codechef.com/START39C/problems/ESUBXOR
 */
package codechef.contest.start.c_39;

import java.util.*;
import java.io.*;

class EvenSubarrayXOR {
    static PrintWriter pw;
    int N = 18;

    // Accepted --- https://www.codechef.com/viewsolution/65172316
    // reference: https://discuss.codechef.com/t/esubxor-editorial/101161
    void solve(int n) {
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 2 * (i + 1);
            b[i] = 2 * (i + 1) + 1;
        }
        // tr(test(a, b));
        outputA(a);
        outputA(b);
    }

    /////////////////////////////////////////////////////////////
    /*
     4    100
     1    001
     5    101

     7    111
     2    010
     5    101
     */
    // don't know
    void solve1(int n) {
        int[][] a = new int[n][N], b = new int[n][N];
        // a
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < N; j += 2) {
                a[i][j] = 1;
            }
        }
        // b
        for (int i = 1; i < n; i += 2) {
            for (int j = 1; j < N; j += 2) {
                b[i][j] = 1;
            }
        }
        tr("a", a);
        tr("b", b);
        int[] ra = transformBitArray(a), rb = transformBitArray(b);
        tr("ra", ra);
        tr("rb", rb);
        tr(test(ra, rb));
        outputA(ra);
        outputA(rb);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    int[] transformBitArray(int[][] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = a[i].length - 1; j >= 0; j--) {
                int pos = a[i].length - j - 1;
                sum += 1 << pos;
            }
            res[i] = sum;
        }
        return res;
    }

    boolean test(int[] a, int[] b) {
        int n = a.length;
        int[] ua = removeDuplicates(a), ub = removeDuplicates(b);
        if (ua.length != n || ub.length != n) return false;
        int[] merge = concat(a, b), um = removeDuplicates(merge);
        if (merge.length != um.length) return false;
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) {
                int[] sa = Arrays.copyOfRange(a, 0, i + 1);
                int[] sb = Arrays.copyOfRange(b, 0, i + 1);
                int A = xorArray(sa), B = xorArray(sb);
                tr("xor", sa, A, sb, B);
                if (A != B) return false;
            }
        }
        return true;
    }

    int xorArray(int[] a) {
        int res = 0;
        for (int x : a) res ^= x;
        return res;
    }

    int[] removeDuplicates(int[] a) {
        Set<Integer> se = new HashSet<>();
        for (int x : a) se.add(x);
        int[] res = new int[se.size()];
        int p = 0;
        for (int x : se) res[p++] = x;
        return res;
    }

    int[] concat(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] res = new int[n + m];
        int p = 0;
        for (int i = 0; i < n; i++) res[p++] = a[i];
        for (int i = 0; i < m; i++) res[p++] = b[i];
        return res;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            solve(n);
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
        new EvenSubarrayXOR().run();
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
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
