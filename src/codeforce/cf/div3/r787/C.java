/**
 * 05/05/22 morning
 * https://codeforces.com/contest/1675/problem/C
 */
package codeforce.cf.div3.r787;

import java.util.*;
import java.io.*;

public class C {
    static PrintWriter pw;

    // Accepted
    void solve(char[] s) {
        List<Integer> ia = new ArrayList<>();
        int n = s.length, notThief = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') ia.add(i);
        }
        // tr(s, ia);
        boolean hasZero = false;
        for (int i = 0; i < n; i++) { // assume ith is thief, find next 1's
            if (hasZero) {
                // tr("notThief zero", i);
                notThief++;
            }
            if (s[i] == '0') hasZero = true;
            int idx = upper_bound(ia, i);
            if (idx != ia.size()) {
                // tr("notThief any", i, "nextOne", idx);
                notThief++;
            }
        }
        // tr(notThief);
        pr(n - notThief);
    }

    int upper_bound(List<Integer> a, int x) {
        int low = 0, high = a.size();
        while (low < high) {
            int mid = low + high >>> 1;
            if (x < a.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            char[] s = fs.next().toCharArray();
            solve(s);
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

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}