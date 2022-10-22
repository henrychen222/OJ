/**
 * 05/25/22 afternoon
 * https://codeforces.com/contest/1686/problem/D
 */
package codeforce.cf.div2.r794;

import java.util.*;
import java.io.*;

public class D {
    static PrintWriter pw;

    // 06/07/22 night complete
    // Accepted --- https://codeforces.com/contest/1686/submission/159918033
    // reference: https://codeforces.com/contest/1685/standings tourist jiangly
    void solve(int a, int b, int c, int d, char[] s) {
        int n = s.length, totalA = a + c + d, A = 0;
        for (char ch : s) {
            if (ch == 'A') A++;
        }
        if (totalA != A) {
            pr("NO");
            return;
        }
        List<Integer> C = new ArrayList<>(), D = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < n; ) {
            int r = i;
            while (r + 1 < n && s[r + 1] != s[r]) r++;
            int t = r - i;
            if (t > 0) {
                total += t / 2;
                if (t % 2 != 0) {
                    if (s[i] == 'A') {
                        C.add(t / 2);
                    } else {
                        D.add(t / 2);
                    }
                }
            }
            i = r + 1;
        }
        Collections.sort(C);
        Collections.sort(D);
        // tr(C, D);
        int remC = c, remD = d;
        for (int x : C) {
            if (remC >= x + 1) {
                remC -= x + 1;
                total++;
            }
        }
        for (int x : D) {
            if (remD >= x + 1) {
                remD -= x + 1;
                total++;
            }
        }
        // tr(total, c, d);
        pr(total >= c + d ? "YES" : "NO");
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int[] a = fs.readArray(4);
            char[] s = fs.next().toCharArray();
            solve(a[0], a[1], a[2], a[3], s);
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
        new D().run();
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