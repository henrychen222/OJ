/**
 * 05/19/23 morning
 * https://codeforces.com/contest/1833/problem/C
 */
package codeforce.cf.div3.y2023.r874;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    void solve(int n, int[] a) {
        int[] b = new int[n], b2 = new int[n];
        TreeSet<Integer> odd = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
            } else {
                odd.add(a[i]);
            }
        }
        boolean buildEven = true, buildOdd = true;
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) {
                b[i] = a[i];
            } else { // odd - odd = even, look for another odd different from a[i], a[j] < a[i]
                // tr("buildEven", a[i], odd.lower(a[i]));
                if (odd.lower(a[i]) != null) {
                    b[i] = a[i] - odd.lower(a[i]);
                } else {
                    buildEven = false;
                }
            }
        }
        // tr(b);
        if (buildEven) {
            pr("YES");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != 0) {
                b2[i] = a[i];
            } else { // even - odd = odd, look for another odd different from a[i], a[j] < a[i]
                // tr("buildOdd", a[i], odd.lower(a[i]));
                if (odd.lower(a[i]) != null) {
                    b[i] = a[i] - odd.lower(a[i]);
                } else {
                    buildOdd = false;
                }
            }
        }
        // tr(b2);
        pr(buildOdd ? "YES" : "NO");
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
        new C().run();
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