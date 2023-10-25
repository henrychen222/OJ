/**
 * 02/08/23 morning
 * https://www.codechef.com/COOK144C/problems/PER_MOD
 */
package codechef.contest.cook.y2023.c_144;

import java.util.*;
import java.io.*;

class PermutationModulus {
    static PrintWriter pw;

    // Accepted
    void solve(int n) {
        int[] a = new int[n];
        a[n - 1] = 1;
        for (int i = 0; i < n - 1; i++) a[i] = i + 2;
//        tr("a", a);
//        tr(test(a));
        outputA(a);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    // Wrong write
    boolean test(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (i + 1 == a[i]) return false;
        }
        int originDis = distinct(a);
        Arrays.sort(a);
        int min = n;
        do {
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = a[i] % (i + 1);
            int curDis = distinct(a);
            tr(a, "curDis", curDis, "distinct", b);
            min = Math.min(n, curDis);
        } while (next_permutation(a));
        tr("min final", min, "originDis", originDis);
        return originDis == min;
    }

    int distinct(int[] a) {
        int n = a.length;
        Set<Integer> se = new HashSet<>();
        for (int i = 0; i < n; i++) se.add(a[i] % (i + 1));
        return se.size();
    }

    boolean next_permutation(int[] a) {
        int n = a.length, i, j;
        for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--) ;
        if (i == -1) return false;
        for (j = i + 1; j < n && a[i] < a[j]; j++) ;
        swap(a, i, j - 1);
        for (int p = i + 1, q = n - 1; p < q; p++, q--) swap(a, p, q);
        return true;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
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
        new PermutationModulus().run();
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
