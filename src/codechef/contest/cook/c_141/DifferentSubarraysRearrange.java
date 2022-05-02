/**
 * 05/01/22 morning
 * https://www.codechef.com/COOK141C/problems/DIFSUBARRAYS
 */
package codechef.contest.cook.c_141;

import java.util.*;
import java.io.*;

class DifferentSubarraysRearrange {
    static PrintWriter pw;

    /*
      reference:
      https://www.codechef.com/viewsolution/63992458

      Accepted --- https://www.codechef.com/viewsolution/64061958 (050122 evening)
     */
    void solve(int n, int[] a) {
        Map<Integer, Integer> m = counter(a);
        if (m.size() <= 2) {
            pr("NO");
            return;
        }
        for (int occ : m.values()) {
            if (occ > n / 2) {
                pr("NO");
                return;
            }
        }
        pr("YES");
        Arrays.sort(a);
        int[] b = Arrays.copyOf(a, n);
        b = rotate(b, n / 2);
        outputA(a);
        outputA(b);
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
    }

    int[] rotate(int[] a, int cut) {
        int n = a.length;
        int[] l = Arrays.copyOfRange(a, 0, cut), r = Arrays.copyOfRange(a, cut, n);
        int[] res = concat(r, l);
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

    Map<Integer, Integer> counter(int[] a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.put(x, m.getOrDefault(x, 0) + 1);
        return m;
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
        new DifferentSubarraysRearrange().run();
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